<script lang="ts">
    import Card from '../Card/Card.svelte';
    import { onMount } from 'svelte';
    import { getAllProductsByUserId } from '$lib/API/getFromAPI/getAllProductsByUserId';
    import type { ProductCard } from '$lib/Objects/productCard';
    import { getUserId } from '$lib/utils';

    let productList: ProductCard[] = [];
    const userPageAccount = window.location.pathname.split('/').pop();
    let userId: string | null = null;

    onMount(async () => {
        userId = getUserId();
        productList = await getAllProductsByUserId(userPageAccount);
    });

    function keepId(id: number) {
        console.log(id);
    }
</script>

<style>
    .products-bloc {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-around;
        margin-left: 50px;
        margin-right: 50px;
    }

    .button-bloc {
        display: flex;
        justify-content: center;
        margin-bottom: 30px;
    }

    button {
        margin-right: 50px;
    }
</style>

<div class="products-bloc">
    {#each productList as item (item.id)}
        <a href="/product/{item.id}/" on:click={() => keepId(item.id)}>
            <Card
                productImageSrc={item.picture}
                productImageDescription={item.description}
                productTitle={item.name}/>
        </a>
    {/each}
</div>
{#if userId === userPageAccount }
    <div class="button-bloc">
        <button class="add"><a href="/addproduct">ajouter un produit</a></button>
    </div>
{/if}

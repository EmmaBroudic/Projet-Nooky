<script lang="ts">
    import { onMount } from 'svelte';
    import { getAllProducts } from '$lib/API/getFromAPI/getAllProducts';
    import Card from '../Card/Card.svelte';
    import type { ProductCard } from '$lib/Objects/productCard';

    let productList: ProductCard[] = [];

    onMount(async () => {
        try {
            productList = await getAllProducts();
        } catch (error) {
            console.error('Error fetching product:', error);
        }
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
<script lang="ts">
    import Card from '../Card/Card.svelte';
    import type { ProductCard } from '$lib/Objects/productCard';
    import '../../assets/css/index.css';

    export let productList: ProductCard[] = [];

    function keepId(id: number) {
        console.log(id);
    }
</script>

<style>
    .products-bloc {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        align-items: center;
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
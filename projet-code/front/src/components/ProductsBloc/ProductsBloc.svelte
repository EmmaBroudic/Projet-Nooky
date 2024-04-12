<script lang="ts">
    import ProductCard from '../../components/ProductCard/ProductCard.svelte';
    import { onMount } from 'svelte';
    import { getAllProducts } from '$lib/getAllProducts';
    //import { writable } from 'svelte/store';
    import type { Product } from '../../lib/product';

    //const selectedProductId = writable<number[]>([]);

    let productList: Product[] = [];

    onMount(async () => {
        try {
            productList = await getAllProducts();
            //selectedProductId.set([]);
        } catch (error) {
            console.error('Error fetching product:', error);
        }
    });

    function keepId(id: number) {
        //selectedProductId.set([id]);
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
            <ProductCard
                productImageSrc={item.picture}
                productImageDescription={item.description}
                productTitle={item.name}/>
        </a>
    {/each}
</div>
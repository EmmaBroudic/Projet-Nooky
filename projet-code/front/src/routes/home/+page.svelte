<script lang="ts">
    import Header from '../../components/Header/Header.svelte';
    import ProductsBloc from '../../components/ProductsBloc/ProductsBloc.svelte';
    import Footer from '../../components/Footer/Footer.svelte';
    import '../../assets/css/index.css';
    import { onMount } from 'svelte';
    import type { ProductCard } from '$lib/Objects/productCard';
    import { getAllProducts } from '$lib/API/getFromAPI/getAllProducts';
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import { getAllProductsByCategory } from '$lib/API/getFromAPI/getAllProductsByCategory';

    let productList: ProductCard[] = [];
    let productListFiltered: ProductCard[] = [];

    let categoryChecked: number;

    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];

    let allProducts: boolean = true;

    let productsFiltered: boolean = false;

    onMount(async () => {
        categoryList = await getAllCategories();
        typeList = await getAllTypes();
        sizeList = await getAllSizes();
    });

    onMount(async () => {
        productList = await getAllProducts();
    });

    async function handleSelect(event: Event) {
        event.preventDefault();
        allProducts = false;

        productListFiltered = await getAllProductsByCategory(categoryChecked);
    }
</script>

<style>
    .bloc-home {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin: 50px;
    }

    .bloc-left {
        width: 170px;
        height: auto;
        background-color: #f6f6f6;
        border-radius: 30px;
        padding: 30px;
    }

    .filter {
      display: flex;
      flex-direction: row;
      margin: 0;
    }

    .filter-check {
      width: 20px;
      height: 20px;
    }

    .bloc-right {
        display: flex;
        flex-direction: column;
        width: 100%;
    }

    .filtres {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin: 30px;
    }
</style>

<Header />
<div class="bloc-home">
    <div class="bloc-left">
        <!--filtres gauche-->
        <h4>Types de produits</h4>
            {#each typeList as item (item.id)}
                <div class="filter">
                    <input class="filter-check" type="checkbox" value={item.id}>
                    <p>{item.label}</p>
                </div>
            {/each}
    </div>
    <div class="bloc-right">
        <!--filtres top-->
        <div class="filtres">
            <button class="grey-border">Tous</button>
            <select name="category" bind:value={categoryChecked} on:click={handleSelect} >
                {#each categoryList as item (item.id)}
                    <option value={item.id}>{item.label}</option>
                {/each}
            </select>
            <button class="grey-border">Tailles</button>
        </div>
        <!--products-->
        {#if allProducts === true}
            <ProductsBloc productList={productList}/>
        {:else}
        <ProductsBloc productList={productListFiltered}/>
        {/if}
    </div>
</div>
<Footer />

<script lang="ts">
    import Header from '../components/Header/Header.svelte';
    import ProductsBloc from '../components/ProductsBloc/ProductsBloc.svelte';
    import Footer from '../components/Footer/Footer.svelte';
    import '../assets/css/index.css';
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
    let filteredProductsList: ProductCard[] = [];
    let categoryChecked: number[] = [];

    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];

    let allProducts: boolean = true;
    let productsFiltered: boolean = false;

    onMount(async () => {
        categoryList = await getAllCategories();
        typeList = await getAllTypes();
        sizeList = await getAllSizes();
        productList = await getAllProducts();
    });

    async function handleSelect(event: Event) {
        event.preventDefault();

        const selectedCategoryId = parseInt((event.target as HTMLInputElement).value);
        console.log("" + selectedCategoryId);
        
        if (selectedCategoryId !== null) {
            if (!categoryChecked.includes(selectedCategoryId)) {
                categoryChecked.push(selectedCategoryId);
                console.log(categoryChecked);
                allProducts = false;
                productsFiltered = true;
                const products = await getAllProductsByCategory(selectedCategoryId);
                productListFiltered = products;
                filteredProductsList = [...filteredProductsList, ...products];
            } else {
                const index = categoryChecked.indexOf(selectedCategoryId);
                if (index !== -1) {
                    // retirer de la liste filteredProductList les éléments sélectopnnés ci-dessous : 
                    //const products = await getAllProductsByCategory(selectedCategoryId);
                    // productListFiltered = products;

                    categoryChecked.splice(index, 1);
                    console.log(categoryChecked);
                }
            }            
        } else {
            allProducts = true;
            productsFiltered = false;
        }
    }
</script>

<style>
    @media screen and (min-width: 800px) {
        .bloc-home {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin: 70px;
        }

        .bloc-left {
            width: 170px;
            height: auto;
            background-color: #f6f6f6;
            border-radius: 30px;
            padding: 30px;
        }

        #bloc-left-mobile {
            display: none;
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
    }
    @media screen and (max-width: 799px) {
        .bloc-home {
            display: flex;
            flex-direction: column;
        }

        .bloc-left {
            display: none;
        }

        #bloc-left-mobile {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .bloc-right {
            display: flex;
            flex-direction: column;
            width: 100%;
        }
    }
</style>

<Header />
<div class="bloc-home">
    <div class="bloc-left">
        <!--filtres gauche-->
        <h4>Catégories</h4>
        <div>
            {#each categoryList as item (item.id)}
                <div class="filter">
                    <input class="filter-check" type="checkbox" value={item.id} on:change={handleSelect}>
                    <p>{item.label}</p>
                </div>
            {/each}
        </div>
        <h4>Types</h4>
        <div>
        {#each typeList as item (item.id)}
            <div class="filter">
                <input class="filter-check" type="checkbox" value={item.id}>
                <p>{item.label}</p>
            </div>
        {/each}
        </div>
    </div>
    <div id="bloc-left-mobile">
        <select name="category">
            {#each categoryList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <select name="size">
            {#each sizeList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
    </div>
    <div class="bloc-right">
        <!--products-->
        {#if allProducts === true}
            <ProductsBloc productList={productList}/>
        {/if}
        {#if productsFiltered === true}
            <ProductsBloc productList={filteredProductsList}/>
        {/if}
    </div>
</div>
<Footer />
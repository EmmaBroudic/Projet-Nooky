<script lang="ts">
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import { onMount } from "svelte";
    import { patchProductById } from '$lib/API/patchToAPI/patchProductById';
    import type { Product } from '$lib/Objects/product.ts';
    import { getUserId } from "$lib/utils";
    import { getProductById, getProductByIdBoolean } from '$lib/API/getFromAPI/getProductById';
    import { goto } from "$app/navigation";
    import '../../../assets/css/index.css';

    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];
    let userId: any;
    let productData: any = {};

    export let product: Product;

    export let inputOneUser: string;
    export let inputTwoUser: string;
    export let inputThreeUser: string;
    export let inputFourUser: string;
    export let selectedCategory: string;
    export let selectedSize: string;
    export let selectedType: string;

    onMount(async () => {

        categoryList = await getAllCategories();
        typeList = await getAllTypes();
        sizeList = await getAllSizes();

        const productId = window.location.pathname.split('/').pop();

        userId = getUserId();
        if (await getProductByIdBoolean(productId) === false) {
            goto("/error");
        } else {
            product = await getProductById(productId);
            userId = getUserId();
            inputOneUser = product.name;
            inputTwoUser = product.description;
            inputThreeUser = product.picture;
            inputFourUser = product.wishlist;
            selectedCategory = product.category;
            selectedType = product.type;
            selectedSize = product.size;
        }
    });

    function handleSubmit(event: Event) {
        event.preventDefault();

        productData.name = inputOneUser;
        productData.description = inputTwoUser;
        productData.picture = inputThreeUser;
        productData.wishlist = inputFourUser;
        productData.userId = userId;
        productData.typeId = selectedType;
        productData.sizeId = selectedSize;
        productData.categoryId = selectedCategory;
        patchProductById(productData);

        goto("/account/"+userId);
    }
</script>

<style>
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin: 20px;
    }

    h2 {
        text-align: center;
        margin-top: 30px;
    }
</style>

<div id="add-product">
    <h2>Modifier un produit</h2>

    <form on:submit={handleSubmit}>
        <input bind:value={inputOneUser} type="text" placeholder="Entrez le nom du produit">
        <input bind:value={inputTwoUser} type="text" placeholder="Entrez la description du produit">
        <input bind:value={inputThreeUser} type="text" placeholder="Entrez l'url de l'image">
        <input bind:value={inputFourUser} type="text" placeholder="Produits souhaités en échange">

        <select name="category" bind:value={selectedCategory}>
            {#each categoryList as item (item.id)}
                <option value={item.label}>{item.label}</option>
            {/each}
        </select>
        <select name="size"  bind:value={selectedSize}>
            {#each sizeList as item (item.id)}
                <option value={item.label}>{item.label}</option>
            {/each}
        </select>
        <select name="type" bind:value={selectedType}>
            {#each typeList as item (item.id)}
                <option value={item.label}>{item.label}</option>
            {/each}
        </select>
        <button class="add" type="submit">Valider</button>
        <p><a href="/account/{userId}">Retour</a></p>
    </form>
</div>
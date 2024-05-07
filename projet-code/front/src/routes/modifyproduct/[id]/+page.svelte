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
    userId = getUserId();

    export let product: Product;

    export let inputOneUser: string;
    export let inputTwoUser: string;
    export let inputThreeUser: string;
    export let inputFourUser: string;
    export let selectedCategory: number;
    export let selectedSize: number;
    export let selectedType: number;

    let productData: any = {};
    const productId = window.location.pathname.split('/').pop();    

    onMount(async () => {
        // faire en sorte que si l'utilisateur n'est pas le propriétaire du produit,
        // il soit rebasculé sur une page error
        if (userId != null) {
            categoryList = await getAllCategories();
            typeList = await getAllTypes();
            sizeList = await getAllSizes();

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
                //selectedCategory = product.category;
                //selectedType = product.type;
                //selectedSize = product.size;
            }
        } else {
            goto("/error");
        }
    });

    function handleSubmit(event: Event) {
        event.preventDefault();

        productData.name = inputOneUser;
        productData.description = inputTwoUser;
        productData.picture = inputThreeUser;
        productData.wishlist = inputFourUser;
        productData.typeId = selectedType;
        productData.sizeId = selectedSize;
        productData.categoryId = selectedCategory;
        console.log(productData);
        patchProductById(productId, productData);

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
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <select name="size"  bind:value={selectedSize}>
            {#each sizeList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <select name="type" bind:value={selectedType}>
            {#each typeList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <button class="add" type="submit">Valider</button>
        <p><a href="/account/{userId}">Retour</a></p>
    </form>
</div>
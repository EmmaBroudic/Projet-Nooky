<script lang="ts">
    import type { Product } from '$lib/Objects/product.ts';
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import { getCategoryByLabel, getSizeByLabel, getTypeByLabel } from "$lib/API/getFromAPI/getProductsElementsByLabel";
    import { getProductById, getProductByIdBoolean } from '$lib/API/getFromAPI/getProductById';
    import { getUserId } from "$lib/utils";
    import { patchProductById } from '$lib/API/patchToAPI/patchProductById';

    import { onMount } from "svelte";
    import { goto } from "$app/navigation";
    
    import '../../../assets/css/index.css';

    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];
    
    let userId: any;

    export let product: Product;

    export let inputOneUser: string;
    export let inputTwoUser: string;
    export let inputThreeUser: string;
    export let inputFourUser: string;
    export let selectedCategory: any;
    export let selectedSize: any;
    export let selectedType: any;

    let productData: any = {};

    export let productId: string | undefined;

    onMount(async () => {
        userId = getUserId();
        productId = window.location.pathname.split('/').pop() || undefined;

        if (userId === null) {
            goto("/error");
        } else {
            categoryList = await getAllCategories();
            typeList = await getAllTypes();
            sizeList = await getAllSizes();

            if (await getProductByIdBoolean(productId) === false) {
                goto("/error");
            } else {
                product = await getProductById(productId);

                if (product.ownerId !== Number(userId)) {
                    goto("/error");
                } else {
                    inputOneUser = product.name;
                    inputTwoUser = product.description;
                    inputThreeUser = product.picture;
                    inputFourUser = product.wishlist;
                    selectedCategory = product.category;
                    selectedType = product.type;
                    selectedSize = product.size;
                }
            }
        }
    });

    async function handleSubmit(event: Event) {
        event.preventDefault();

        let type: Type;
        let size: Size;
        let category: Category;

        type = await getTypeByLabel(selectedType);
        size = await getSizeByLabel(selectedSize);
        category = await getCategoryByLabel(selectedCategory);

        productData.name = inputOneUser;
        productData.description = inputTwoUser;
        productData.picture = inputThreeUser;
        productData.wishlist = inputFourUser;
        productData.typeId = type.id;
        productData.sizeId = size.id;
        productData.categoryId = category.id;
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
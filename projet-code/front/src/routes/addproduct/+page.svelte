<script lang="ts">
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import { postProduct } from '$lib/API/postToAPI/postProduct';
    import { getUserId } from "$lib/utils";

    import { onMount } from "svelte";
    import { goto } from "$app/navigation";

    import '../../assets/css/index.css';


    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];

    let userId: any;

    let productData: any = {};
    
    let selectedCategory: number;
    let selectedSize: number;
    let selectedType: number;

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;
    let inputFourUser: string;

    let hasError: boolean = false;

    const regexInputOneUser = /^.{0,50}$/;
    const regexInputTwoUser = /^.{0,400}$/;
    const regexInputThreeUser = /^.{0,1000}$/;
    const regexInputFourUser = /^.{0,200}$/;
    
    onMount(async () => {
        userId = getUserId();

        if (userId === null) {
            goto("/error");
        } else {
            categoryList = await getAllCategories();
            typeList = await getAllTypes();
            sizeList = await getAllSizes();
        }
    });

    function handleSubmit(event: Event) {
        event.preventDefault();

        if (!regexInputOneUser.test(inputOneUser)) {
            hasError = true;
        } else if (!regexInputTwoUser.test(inputTwoUser)) {
            hasError = true;
        } else if (!regexInputThreeUser.test(inputThreeUser)) {
            hasError = true;
        } else if (!regexInputFourUser.test(inputFourUser)) {
            hasError = true;
        } else {
            productData.name = inputOneUser;
            productData.description = inputTwoUser;
            productData.picture = inputThreeUser;
            productData.wishlist = inputFourUser;
            productData.userId = userId;
            productData.typeId = selectedType;
            productData.sizeId = selectedSize;
            productData.categoryId = selectedCategory;
            postProduct(productData);

            goto("/myaccount/"+userId);
        }
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

{#if userId}
    <div id="add-product">
        <h2>Ajouter un produit</h2>

        <form on:submit={handleSubmit}>
            <input bind:value={inputOneUser} type="text" placeholder="Entrez le nom du produit" required>
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
            {#if hasError === true}
                <p class="error-message">Les données envoyées doivent respecter le format ci-dessous :</p>
                <p class="error-message">Titre de l'article : 50 caractères maximum</p>
                <p class="error-message">Description de l'article : 400 caractères maximum</p>
                <p class="error-message">Url de l'image : 1000 caractères maximum</p>
                <p class="error-message">Wishlist : 200 caractères maximum</p>
            {/if}
            <button class="add" type="submit">Valider</button>
            <p><a href="/myaccount/{userId}">Retour</a></p>
        </form>
    </div>
{/if}

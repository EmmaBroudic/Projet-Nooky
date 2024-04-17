<script lang="ts">
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import { onMount } from "svelte";
    import { postProduct } from '$lib/API/postToAPI/postProduct';
    import '../../assets/css/index.css';
    //import { getUserId } from "$lib/utils";

    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];
    let productData: any = {};
    
    let selectedCategory: number;
    let selectedSize: number;
    let selectedType: number;

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;

    onMount(async () => {
        try {
            categoryList = await getAllCategories();
            typeList = await getAllTypes();
            sizeList = await getAllSizes();
        } catch (error) {
            console.error('Error fetching product:', error);
        }
    });

    function handleSubmit(event: Event) {
        event.preventDefault();

        productData.name = inputOneUser;
        productData.description = inputTwoUser;
        productData.picture = inputThreeUser;
        productData.userId = 1;
        productData.typeId = selectedType;
        productData.sizeId = selectedSize;
        productData.categoryId = selectedCategory;

        postProduct(productData);
        console.log(productData);
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
    <h2>Ajouter un produit</h2>
    
    <form on:submit={handleSubmit}>
        <input bind:value={inputOneUser} type="text" placeholder="Entrez le nom du produit">
        <input bind:value={inputTwoUser} type="text" placeholder="Entrez la description du produit">
        <input bind:value={inputThreeUser} type="text" placeholder="Entrez l'url de l'image'">
        
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
    </form>
</div>
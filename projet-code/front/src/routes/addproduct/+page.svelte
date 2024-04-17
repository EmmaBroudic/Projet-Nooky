<script lang="ts">
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import { onMount } from "svelte";
    import { postProduct } from '$lib/API/postToAPI/postProduct';

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

    function handleCategoryChange(event: Event) {
        selectedCategory = parseInt((event.target as HTMLSelectElement).value);
        productData.category = selectedCategory;
        console.log('Selected category:', selectedCategory);
    }

    function handleSizeChange(event: Event) {
        selectedSize = parseInt((event.target as HTMLSelectElement).value);
        productData.size = selectedSize;
        console.log('Selected size:', selectedSize);
    }

    function handleTypeChange(event: Event) {
        selectedType = parseInt((event.target as HTMLSelectElement).value);
        productData.type = selectedType;
        console.log('Selected type:', selectedType);
    }

    function handleSubmit(event: Event) {
        event.preventDefault();

        productData.name = inputOneUser;
        productData.description = inputTwoUser;
        productData.picture = inputThreeUser;
        productData.userId = 1;
        productData.typeId = selectedType;
        productData.sizeId = selectedSize;
        productData.categoryId = selectedCategory;

        console.log(productData);
        postProduct(productData);
    }
</script>

<style>
    #add-product {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>

<div id="add-product">
    <h2>Ajouter un produit</h2>
    
    <form on:submit={handleSubmit}>
        <input bind:value={inputOneUser} type="text" placeholder="Entrez le nom du produit">
        <input bind:value={inputTwoUser} type="text" placeholder="Entrez la description du produit">
        <input bind:value={inputThreeUser} type="text" placeholder="Entrez l'url de l'image'">
        
        <select name="category" bind:value={selectedCategory} on:change={handleCategoryChange}>
            {#each categoryList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <select name="size"  bind:value={selectedSize} on:change={handleSizeChange}>
            {#each sizeList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <select name="type" bind:value={selectedType} on:change={handleTypeChange}>
            {#each typeList as item (item.id)}
                <option value={item.id}>{item.label}</option>
            {/each}
        </select>
        <button class="add" type="submit">Valider</button>
    </form>
</div>

<!--<script lang="ts">
    import '../../assets/css/index.css';
    import { onMount } from 'svelte';
    import { keepInputsProduct } from '../../lib/keepInputs';
    import { goto } from '$app/navigation';

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;

    function keepUserInputs() {
        let data = {
            id: 1,
            name: inputOneUser,
            description: inputTwoUser,
            picture: inputThreeUser
        };
        keepInputsProduct.update((prevData) => [...prevData, data]);
        console.log(data);
    }

    function handleSubmit(event: any) {
        event.preventDefault();
        keepUserInputs();
        goto('/account');
    }

    onMount(() => {
        keepUserInputs();
    });
</script>

<form class="connect" on:submit|preventDefault={handleSubmit}>
    <h2>Ajouter un produit</h2>
    <input bind:value={inputOneUser} type="name" placeholder="Entrez le nom du produit">
    <input bind:value={inputTwoUser} type="description" placeholder="Entrez la description du produit">
    <input bind:value={inputThreeUser} type="picture" placeholder="Entrez l'url de l'image'">
    <button class="add" type="submit">Valider</button>
    <p><a href="/account">Retour</a></p>
</form>-->
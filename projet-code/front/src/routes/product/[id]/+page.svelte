<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import Footer from '../../../components/Footer/Footer.svelte';
    import { onMount } from 'svelte';
    import { getProductById, getProductByIdBoolean } from '$lib/API/getFromAPI/getProductById';
    import type { Product } from '$lib/Objects/product.ts';
    import { getUserId } from '$lib/utils';
    import '../../../assets/css/index.css';
    import { goto } from '$app/navigation';

    export let product: Product;
    let userId: string | null = null;

    onMount(async () => {
        const productId = window.location.pathname.split('/').pop();

        if (await getProductByIdBoolean(productId) === false) {
            goto("/error");
        } else {
            product = await getProductById(productId);
            userId = getUserId();
        }
    });
</script>

<style>
    #bloc-product {
        display: flex;
        flex-direction: column;
    }

    #wishlist {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 88%;
        border: solid 3px #f6f6f6;
        border-radius: 25px;
        margin-left: 30px;
        margin-right: 30px;
        margin-bottom: 30px;
        height: auto;
        border-radius: 30px;
        padding: 30px;
        text-align: center;
    }
</style>

<Header />
<div id="bloc-product">
    {#if product}
        <InformationBloc
        blocTitle={product.name}
        imgUrl={product.picture}
        descriptionTitle={product.description}
        infoOne={"Catégorie : " + product.category}
        infoTwo= {"Type : " + product.type}
        infoThree= {"Taille : " + product.size}
        infoFour= {"Proposé par : " + product.usernameOwner}
        infoSix= {"/account/"+ product.ownerId}
        infoFive= {"Produit ajouté au vestiaire le : " + product.addedAt}/>
    {/if}
    {#if userId !== null}
        {#if product.ownerId !== userId}
            <div id="wishlist">
                <p>J'aimerais échanger ce produit contre : {product.wishlist}</p>
                <button class="modify">Faire une proposition d'échange</button>
            </div>
        {:else}
            <div id="wishlist">
                <p>J'aimerais échanger ce produit contre : {product.wishlist}</p>
                <button class="modify">Modifier la fiche produit</button>
            </div>
        {/if}
    {/if}
</div>
<Footer />
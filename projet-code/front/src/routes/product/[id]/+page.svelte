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
            console.log(userId);
            console.log(userId + product.ownerId);
        }
    });
</script>

<style>
    @media screen and (min-width: 1110px) {
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

        #supp {
            border: 0px;
            background-color: white;
            color: red;
        }
    }

    @media screen and (min-width: 800px) and (max-width: 1109px) {
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

        #supp {
            border: 0px;
            background-color: white;
            color: red;
        }
    }
    @media screen and (max-width: 799px) {
        #bloc-product {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        #wishlist {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 70%;
            border: solid 3px #f6f6f6;
            border-radius: 25px;
            margin-bottom: 30px;
            height: auto;
            padding: 30px;
            text-align: center;
        }

        #supp {
            border: 0px;
            background-color: white;
            color: red;
        }
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
        <div id="wishlist">
            <p>J'aimerais échanger ce produit contre : {product.wishlist}</p>
            {#if product.ownerId != userId}
                <button class="modify">Faire une proposition d'échange</button>
            {/if}
            {#if product.ownerId == userId}
                <button class="modify">Modifier la fiche produit</button>
                <button id="supp">Supprimer le produit</button>
            {/if}
        </div>
    {/if}
</div>
<Footer />
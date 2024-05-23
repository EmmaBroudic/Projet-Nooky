<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import Footer from '../../../components/Footer/Footer.svelte';

    import type { Product } from '$lib/Objects/product.ts';
    import { getProductById, getProductByIdBoolean } from '$lib/API/getFromAPI/getProductById';
    import { deleteProductById } from '$lib/API/deleteToAPI/deleteProductById';
    import { getUserId } from '$lib/utils';

    import { onMount } from 'svelte';
    import { goto } from '$app/navigation';

    import '../../../assets/css/index.css';

    export let product: Product;
    let userId: string | null = null;
    export let productId: string | undefined;

    onMount(async () => {
        productId = window.location.pathname.split('/').pop() || undefined;

        if (await getProductByIdBoolean(productId) === false) {
            goto("/error");
        } else {
            product = await getProductById(productId);
            userId = getUserId();
        }
    });

    function deleteProduct() {
        productId = window.location.pathname.split('/').pop() || undefined;

        deleteProductById(productId);
        goto("/account/"+userId);
    }
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
            width: 90%;
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
            cursor: pointer;
            border: 0px;
            background-color: white;
            color: red;
        }
    }

    @media screen and (min-width: 820px) and (max-width: 1109px) {
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
            cursor: pointer;
            border: 0px;
            background-color: white;
            color: red;
        }
    }
    @media screen and (max-width: 819px) {
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
            cursor: pointer;
            color: red;
            background-color: white;
            border: 0px;
        }
    }
    
</style>

{#if product}
    <Header />
    <div id="bloc-product">
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
        
        {#if userId !== null}
            <div id="wishlist">
                <p>J'aimerais échanger ce produit contre : {product.wishlist}</p>
                {#if product.ownerId != userId}
                    <button class="modify">Faire une proposition d'échange</button>
                {/if}
                {#if product.ownerId == userId}
                    <button class="modify"><a href="/modifyproduct/{productId}">Modifier la fiche produit</a></button>
                    <button on:click={deleteProduct} id="supp">Supprimer le produit</button>
                {/if}
            </div>
        {/if}
    </div>
    <Footer />
{/if}
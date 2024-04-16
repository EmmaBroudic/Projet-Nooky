<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import Footer from '../../../components/Footer/Footer.svelte';
    import { onMount } from 'svelte';
    import { getProductById } from '$lib/getProductById';
    import type { Product } from '$lib/product';

    export let product: Product;

    onMount(async () => {
        try {
            const productId = window.location.pathname.split('/').pop();
            console.log(productId);
            product = await getProductById(productId);
        } catch (error) {
            console.error('Error fetching product:', error);
        }
    });
</script>

<style>
    #wishlist {
        width: 90%;
        margin-left: 30px;
        margin-right: 30px;
        margin-bottom: 30px;
        background-color: #f6f6f6;
        height: auto;
        border-radius: 30px;
        padding: 30px;
        text-align: center;
    }
</style>

<Header />
{#if product}
    <InformationBloc
    blocTitle={product.name}
    imgUrl={product.picture}
    descriptionTitle={product.description}
    infoOne={"Catégorie : " + product.category}
    infoTwo= {"Type : " + product.type}
    infoThree= {"Taille : " + product.size}
    infoFour= {"Proposé par : " + product.usernameOwner}
    infoFive= {"Produit ajouté au vestiaire le : " + product.addedAt}
    pageDirection= "/home"
    buttonText="faire une proposition d'échange"/>
{/if}
{#if product}
    <p id="wishlist">J'aimerais échanger ce produit contre : {product.wishlist}</p>
{/if}
<Footer />
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
    /*h2 {
        margin-top: 50px;
        margin-left: 70px;
    }

    .bloc-products {
        display: flex;
        flex-direction: column;
        justify-content: flex-end;
    }

    button {
        margin-left: auto;
        margin-right: 30px;
    }*/
</style>

<Header />
{#if (product !=null)}
    <InformationBloc blocTitle={product.name} imgUrl={product.picture} descriptionTitle={product.name} descriptionText={product.description} pageDirection="/home" buttonText="faire une proposition d'échange"/>
{/if}
<Footer />
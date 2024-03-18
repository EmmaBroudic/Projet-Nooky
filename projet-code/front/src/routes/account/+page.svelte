<script lang="ts">
    import Header from '../../components/Header/Header.svelte';
    import InformationBloc from '../../components/InformationBloc/InformationBloc.svelte';
    import ProductsBloc from '../../components/ProductsBloc/ProductsBloc.svelte';
    import Footer from '../../components/Footer/Footer.svelte';
</script>

<style>
    h2 {
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
    }

   /* .bloc-top, .bloc-bottom {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
    }

    .bloc-bottom {
        flex-wrap: wrap;
    }

    img {
        width: 300px;
        height: 300px;
        border-radius: 30px;
        object-fit: cover;
        margin: 30px;
    }

    .description {
        width: 70%;
        margin: 30px;
        background-color: #f6f6f6;
        height: 240px;
        border-radius: 30px;
        padding: 30px;
    }

    h2 {
        margin-left: 50px;
    }*/
</style>

<Header />
<InformationBloc blocTitle="Mon compte" imgUrl="https://img.freepik.com/photos-gratuite/femme-son-chien-husky-dans-parc_1303-23169.jpg" descriptionTitle="Mes informations" descriptionText="bla bla bla" buttonText="modifier"/>
<h2>Mes produits</h2>
<div class="bloc-products">
    <ProductsBloc />
    <button>ajouter un produit</button>
</div>
<Footer />
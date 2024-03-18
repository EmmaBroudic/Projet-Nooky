<script lang="ts">
    import Header from '../../components/Header/Header.svelte';
    import ProductsBloc from '../../components/ProductsBloc/ProductsBloc.svelte';
    import Footer from '../../components/Footer/Footer.svelte';
</script>

<style>
    .bloc-home {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin: 50px;
    }

    .bloc-left {
        width: 250px;
        height: 1000px;
        background-color: grey;
        border-radius: 30px;
    }

    .bloc-right {
        display: flex;
        flex-direction: column;
        width: 100%;
    }

    .filtres {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin: 30px;
    }
</style>

<Header />
<div class="bloc-home">
    <div class="bloc-left">
        <p>colonne de filtres</p>
    </div>
    <div class="bloc-right">
        <div class="filtres">
            <p>filtre 1</p>
            <p>filtre 2</p>
            <p>filtre 3</p>
        </div>
        <ProductsBloc />
    </div>
</div>
<Footer />

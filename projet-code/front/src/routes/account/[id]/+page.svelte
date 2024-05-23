<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import ProductsBloc from '../../../components/ProductsBloc/ProductsBloc.svelte';
    import Footer from '../../../components/Footer/Footer.svelte';
    
    import type { ProductCard } from '$lib/Objects/productCard';
    import type { User } from '$lib/Objects/user';
    import { getUserId } from '$lib/utils';
    import { getUserById, getUserByIdBoolean } from '$lib/API/getFromAPI/getUserById';
    import { getAllProductsByUserId } from '$lib/API/getFromAPI/getAllProductsByUserId';

    import { onMount } from 'svelte';
    import { goto } from '$app/navigation';

    import '../../../assets/css/index.css';

    export let user: User;
    let userId: string | null = null;
    let userPageAccount: any;

    let productList: ProductCard[] = [];

    onMount(async () => {
        userPageAccount = window.location.pathname.split('/').pop();

        if (await getUserByIdBoolean(userPageAccount) === false) {
            goto("/error");
        } else {
            userId = getUserId();
            user = await getUserById(userPageAccount);
            productList = await getAllProductsByUserId(userPageAccount);
        }
    });
</script>

<style>
    #bloc-account {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    @media screen and (min-width: 1110px) {
        h2 {
            margin-top: 50px;
            margin-left: 70px;
        }
    }

    @media screen and (min-width: 800px) and (max-width: 1109px) {
        h2 {
            margin-top: 50px;
            margin-left: 70px;
        }
    }
    
    @media screen and (max-width: 799px) {
        h2 {
            margin-top: 50px;
            text-align: center;
        }
    }
</style>

<Header />
<div id="bloc-account">
    {#if user}
        <InformationBloc
        blocTitle="Mon compte"
        imgUrl={user.picture}
        descriptionTitle={user.username}
        infoOne={"Prénom : " + user.firstname}
        infoTwo={"Nom de famille : " + user.lastname}
        infoThree={"Description : " + user.description}
        infoFour={"Inscrit depuis le : " + user.createdAt}
        infoFive={"Habite à : " + user.city}
        infoSix=""/>
    {/if}
</div>
<h2>Mon vestiaire</h2>
<ProductsBloc productList={productList}/>
<Footer />
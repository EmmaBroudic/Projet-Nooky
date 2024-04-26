<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import ProductsBloc from '../../../components/ProductsBloc/ProductsBloc.svelte';
    import type { ProductCard } from '$lib/Objects/productCard';
    import Footer from '../../../components/Footer/Footer.svelte';
    import type { User } from '$lib/Objects/user';
    import { onMount } from 'svelte';
    import { getUserId } from '$lib/utils';
    import { getUserById, getUserByIdBoolean } from '$lib/API/getFromAPI/getUserById';
    import '../../../assets/css/index.css';
    import { goto } from '$app/navigation';
    import { getAllProductsByUserId } from '$lib/API/getFromAPI/getAllProductsByUserId';

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
    @media screen and (min-width: 1110px) {
        h2 {
            margin-top: 50px;
            margin-left: 70px;
        }

        .button-bloc {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }

        button {
            align-items: center;
        }
    }

    @media screen and (min-width: 800px) and (max-width: 1109px) {
        h2 {
            margin-top: 50px;
            margin-left: 70px;
        }

        .button-bloc {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }

        button {
            align-items: center;
        }
    }
    @media screen and (max-width: 799px) {
        h2 {
            margin-top: 50px;
            text-align: center;
        }

        .button-bloc {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }

        button {
            align-items: center;
        }
    }
</style>

<Header />
{#if user}
    <InformationBloc
    blocTitle="Mon compte"
    imgUrl={user.picture}
    descriptionTitle={user.username}
    infoOne={user.firstname}
    infoTwo={user.lastname}
    infoThree={user.description}
    infoFour={user.createdAt}
    infoFive={user.city}
    infoSix=""/>
{/if}
{#if userId === userPageAccount }
    <div class="button-bloc">
        <button class="add">Modifier</button>
    </div>
{/if}
<h2>Mon vestiaire</h2>
<ProductsBloc productList={productList}/>
{#if userId === userPageAccount }
    <div class="button-bloc">
        <button class="add"><a href="/addproduct">ajouter un produit</a></button>
    </div>
{/if}
<Footer />
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
        userId = getUserId();
        if (await getUserByIdBoolean(userPageAccount) === false) {
            goto("/error");
        } else if (userId !== userPageAccount) {
            goto("/error");
        } else {
            user = await getUserById(userId);
            productList = await getAllProductsByUserId(userId);
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

        .button-bloc {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }

        button {
            align-items: center;
        }

        #infos-perso {
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

        #infos-perso {
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

        #infos-perso {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 70%;
            border: solid 3px #f6f6f6;
            border-radius: 25px;
            margin: 20px;
            height: auto;
            padding: 30px;
            text-align: center;
        }
    }
</style>

{#if user && userId === userPageAccount}
<Header />
    <div id="bloc-account">
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
            <div id="infos-perso">
                <h3>Informations non-visibles pour les autres utilisateurs</h3>
                <p>Addresse postale : {user.road}, {user.zipCode} {user.city}</p>
                <p>Email : {user.email}</p>
            </div>
            <div class="button-bloc">
                <button class="add"><a href="/modifyaccount">Modifier</a></button>
            </div>
    </div>
    <h2>Mon vestiaire</h2>
    <ProductsBloc productList={productList}/>
    <div class="button-bloc">
        <button class="add"><a href="/addproduct">Ajouter un produit</a></button>
    </div>
<Footer />
{/if}
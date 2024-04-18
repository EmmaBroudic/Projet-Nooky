<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import Wardrobe from '../../../components/Wardrobe/Wardrobe.svelte';
    import Footer from '../../../components/Footer/Footer.svelte';
    import type { User } from '$lib/Objects/user';
    import { onMount } from 'svelte';
    //import { goto } from '$app/navigation';
    import { getUserId } from '$lib/utils';
    import { getUserById, getUserByIdBoolean } from '$lib/API/getFromAPI/getUserById';
    import '../../../assets/css/index.css';
    import { goto } from '$app/navigation';

    export let user: User;
    let userId: string | null = null;
    let userPageAccount: any;

    onMount(async () => {
        userPageAccount = window.location.pathname.split('/').pop();
        userId = getUserId();
        user = await getUserById(userPageAccount);

        if (await getUserByIdBoolean(userPageAccount) === false) {
            goto("/error");
        } else {
            userId = getUserId();
            user = await getUserById(userPageAccount);
        }
    });
</script>

<style>
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
        margin-right: 50px;
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
        <button class="add">Mofifier</button>
    </div>
{/if}
<h2>Mon vestiaire</h2>
<Wardrobe />
<Footer />
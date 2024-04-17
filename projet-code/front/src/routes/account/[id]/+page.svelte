<script lang="ts">
    import Header from '../../../components/Header/Header.svelte';
    import InformationBloc from '../../../components/InformationBloc/InformationBloc.svelte';
    import Footer from '../../../components/Footer/Footer.svelte';
    import { getUserById } from '$lib/API/getFromAPI/getUserById';
    import type { User } from '$lib/Objects/user';
    import { onMount } from 'svelte';
    import Wardrobe from '../../../components/Wardrobe/Wardrobe.svelte';
    import { getUserId } from '$lib/utils';
    import { goto } from '$app/navigation';

    export let user: User;

    let userId: string | null = null;
    onMount(async () => {
        userId = getUserId();
        if (userId !== null) {
            user = await getUserById(userId);
            if (!user) {
                goto("/error");
            }
        } else {
            goto("/error");
        }
    });
</script>

<style>
    h2 {
        margin-top: 50px;
        margin-left: 70px;
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
    pageDirection= "/signup"
    buttonText="Modifier"/>
{/if}
<h2>Mes produits</h2>
<Wardrobe />
<Footer />
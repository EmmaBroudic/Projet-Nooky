<script lang="ts">
    import { getUserByEmail } from '$lib/API/getFromAPI/getUserByEmail';
    import { getUserById } from '$lib/API/getFromAPI/getUserById';
    import { getUserId } from "$lib/utils";
    import { onMount } from 'svelte';

    import type { User } from '$lib/Objects/user';


    import { goto } from '$app/navigation';
    import { patchUserById } from '$lib/API/patchToAPI/patchUserById';

    import '../../assets/css/index.css';

    let userId: any;
    userId = getUserId();

    export let user: User;

    // ajouter une récupération de l'id url afin de comparer les url

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;
    let inputFourUser: string;
    let inputFiveUser: string;
    let inputSixUser: string;
    let inputSevenUser: string;
    let inputEightUser: string;
    let inputNineUser: string;

    let userData: any = {};

    onMount(async () => {
        // vérifier que l'email ajouté n'exite pas déjà
        if (userId != null) {
            console.log("test");
            user = await getUserById(userId);

            inputOneUser = user.username;
            inputTwoUser = user.email;
            inputThreeUser = user.firstname;
            inputFourUser = user.lastname;
            inputFiveUser = user.description;
            inputSixUser = user.road;
            inputSevenUser = user.city;
            inputEightUser = user.zipCode;
            inputNineUser = user.picture;

        } else {
            goto("/error");
        }
    });

    async function handleSubmit(event: any) {
        event.preventDefault();

        userData.username = inputOneUser;
        userData.email = inputTwoUser;
        userData.firstname = inputThreeUser;
        userData.lastname = inputFourUser;
        userData.description = inputFiveUser;
        userData.addressRoad = inputSixUser;
        userData.addressCity = inputSevenUser;
        userData.addressZipCode = inputEightUser;
        userData.picture = inputNineUser;

        patchUserById(userId, userData);

        goto("/account/"+userId);
    }
</script>

<style>
    /*#redir-signin {
        display: flex;
        flex-direction: column;
        text-align: center;
        margin: 100px;
    }*/
</style>

<form class="connect" on:submit={handleSubmit}>
        
    <h2>Sign up</h2>
    
    <input bind:value={inputOneUser} type="username" placeholder="Entrez votre nom d'utilisateur" required>
    <input bind:value={inputTwoUser} type="email" placeholder="Entrez votre email" required>
    <input bind:value={inputThreeUser} type="firstname" placeholder="Entrez votre prénom" required>
    <input bind:value={inputFourUser} type="lastname" placeholder="Entrez votre nom de famille" required>
    <input bind:value={inputNineUser} type="picture" placeholder="Ajoutez l'url d'une image" required>
    <input bind:value={inputFiveUser} type="description" placeholder="Entrez une description" required>
    <input bind:value={inputSixUser} type="road" placeholder="Entrez votre numéro et rue" required>
    <input bind:value={inputEightUser} type="text" placeholder="Entrez votre code postal" required>
    <input bind:value={inputSevenUser} type="city" placeholder="Entrez votre ville" required>

    <button class="modify" type="submit">Valider</button>
</form>
<script lang="ts">
    import { getUserByEmail } from '$lib/API/getFromAPI/getUserByEmail';
    import { getUserById } from '$lib/API/getFromAPI/getUserById';
    import { getUserId } from "$lib/utils";
    import { patchUserById } from '$lib/API/patchToAPI/patchUserById';
    import type { User } from '$lib/Objects/user';
    import { onMount } from 'svelte';
    import { goto } from '$app/navigation';

    import '../../assets/css/index.css';

    let userId: any;
    userId = getUserId();

    export let user: User;

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

    let hasError: boolean = false;
    let hasErrorEmail: boolean = false;
    let hasErrorZipCode: boolean = false;
    let hasErrorUserExist: boolean = false;

    let submitted: boolean = false;

    const errorMessageVisible = "La modification n'a pas fonctionnée, le compte n'a pas été créé";
    const errorUserExist = "Une compte utilisateur avec cette adresse email existe déjà, veuillez ajouter une autre adresse mail"
    const errorEmail = "Email invalide";
    const errorZipCode = "Code postal invalide";

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const zipCodeRegex = /^[0-9]{5}$/;

    onMount(async () => {
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

        if (!emailRegex.test(inputTwoUser)) {
            hasErrorEmail = true;
        } else if (!zipCodeRegex.test(inputEightUser)) {
            hasErrorZipCode = true;
        } else {
            submitted = await patchUserById(userId, userData);

            if (submitted === true) {
                goto("/account/"+userId);
            } else {
                hasError = true;
                const userExist = await getUserByEmail(inputTwoUser);
                if (userExist !== null) {
                    hasErrorUserExist = true;
                }
            }
        }
    }
</script>

<form class="connect" on:submit={handleSubmit}>
        
    <h2>Modify account</h2>
    
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

    {#if hasErrorEmail === true}
        <p class="error-message">{errorEmail}</p>
    {/if}

    {#if hasErrorZipCode === true}
        <p class="error-message">{errorZipCode}</p>
    {/if}

    {#if hasError === true}
        <p class="error-message">{errorMessageVisible}</p>
        {#if hasErrorUserExist === true}
            <p class="error-message">{errorUserExist}</p>
        {/if}
    {/if}
</form>
<!--<script lang="ts">
    import { onMount } from 'svelte';
    import '../../assets/css/index.css';
    import { goto } from '$app/navigation';
    import { verifyInputsSignIn } from '$lib/getData';

    let inputOneUser: string;
    let inputTwoUser: string;
    let errorMessageVisible = false;

    async function handleSubmit(event: any) {
        event.preventDefault();
        
        const result = await verifyInputsSignIn(inputOneUser, inputTwoUser);
            
        if (result === false) {
            errorMessageVisible = true;
        } /*else if (!inputOneUser) {
            console.log("l'identifiant n'est pas bon");
            errorMessageVisible = true;
        } */else {
            goto('/home');
        }
    }
/*
    onMount(() => {
        // Au moment du montage, on cache le message d'erreur
        errorMessageVisible = false;
    });*/
</script>

<style>
    .error-message {
        color: red;
        font-size: 12px;
        display: flex;
    }
</style>

<form class="connect" on:submit|preventDefault={handleSubmit}>
    <h2>Sign in</h2>
    <input bind:value={inputOneUser} type="email" placeholder="Entrez votre email">
    <input bind:value={inputTwoUser} type="password" placeholder="Entrez votre mot de passe">
    {#if errorMessageVisible === true}
        <p class="error-message">Identifiant et mot de passe erronés</p>
    {:else}
        <p>TestS</p>
    {/if}
    <button class="add" type="submit">Valider</button>
    <p><a href="/">Retour</a></p>
</form>-->
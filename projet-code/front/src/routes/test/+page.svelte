<script lang="ts">

    import '../../assets/css/index.css';
    import { goto } from '$app/navigation';
    import { verifyInputsToken } from '$lib/getDataTest';

    let inputOneUser: string;
    let inputTwoUser: string;
    let errorMessageVisible = false;

    async function handleSubmit(event: any) {
        event.preventDefault();
        
        const result = await verifyInputsToken(inputOneUser, inputTwoUser);
            
        if (result === false) {
            errorMessageVisible = true;
        } else {
            goto('/home');
        }
    }
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
    <input bind:value={inputOneUser} type="text" placeholder="Entrez votre identifiant">
    <input bind:value={inputTwoUser} type="password" placeholder="Entrez votre mot de passe">
    {#if errorMessageVisible === true}
        <p class="error-message">Identifiant et mot de passe erronés</p>
    {:else}
        <p>TestS</p>
    {/if}
    <button class="add" type="submit">Valider</button>
    <p><a href="/">Retour</a></p>
</form>
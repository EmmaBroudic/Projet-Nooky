<script lang="ts">
    import { goto } from '$app/navigation';
    import { verifyInputsSignIn } from '$lib/API/getFromAPI/getUserByEmail';
    
    import '../../assets/css/index.css';

    let inputOneUser: string;
    let inputTwoUser: string;
    let errorMessageVisible = false;

    async function handleSubmit(event: any) {
        event.preventDefault();
        
        const result = await verifyInputsSignIn(inputOneUser, inputTwoUser);
            
        if (result === false) {
            errorMessageVisible = true;
        } else {
            goto('/home');
        }
    }
</script>

<form class="connect" on:submit|preventDefault={handleSubmit}>
    <h2>Sign in</h2>
    <input bind:value={inputOneUser} type="email" placeholder="Entrez votre email">
    <input bind:value={inputTwoUser} type="password" placeholder="Entrez votre mot de passe">
    {#if errorMessageVisible === true}
        <p class="error-message">Identifiant et mot de passe erronés</p>
    {/if}
    <button class="add" type="submit">Valider</button>
    <p><a href="/">Retour</a></p>
</form>
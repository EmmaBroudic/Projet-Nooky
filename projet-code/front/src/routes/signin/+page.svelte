<script lang="ts">
    import { postSignIn } from '$lib/API/postToAPI/postSignIn';

    import { goto } from '$app/navigation';

    import '../../assets/css/index.css';

    let inputOneUser: string;
    let inputTwoUser: string;
    let userData: any = {};
    let errorMessageVisible = false;

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    let hasErrorEmail: boolean = false;

    const errorEmail = "Email invalide";

    async function handleSubmit(event: any) {
        event.preventDefault();

        userData.email = inputOneUser;
        userData.password = inputTwoUser;

        if (!emailRegex.test(inputOneUser)) {
            hasErrorEmail = true;
        } else {
            const result = await postSignIn(userData);
            
            if (result === false) {
                errorMessageVisible = true;
            } else {
                goto('/');
            }
        }
    }
</script>

<form class="connect" on:submit|preventDefault={handleSubmit}>
    <h2>Sign in</h2>
    <input bind:value={inputOneUser} type="email" placeholder="Entrez votre email">
    <input bind:value={inputTwoUser} type="password" placeholder="Entrez votre mot de passe">
    {#if hasErrorEmail === true}
        <p class="error-message">{errorEmail}</p>
    {/if}
    {#if errorMessageVisible === true}
        <p class="error-message">Identifiant et mot de passe erronés</p>
    {/if}
    <button class="add" type="submit">Valider</button>
    <p><a href="/connexion">Retour</a></p>
</form>
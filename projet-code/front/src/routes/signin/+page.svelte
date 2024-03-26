<script lang="ts">
    import '../../assets/css/index.css';
    import { onMount } from 'svelte';
    import { keepInputsSignIn } from '../../lib/keepInputs';
    import { goto } from '$app/navigation';
    import { postInputsSignIn } from '$lib/postInputs';

    let inputOneUser: string;
    let inputTwoUser: string;

    function keepUserInputs() {
        let data = {
            id: 1,
            email: inputOneUser,
            password: inputTwoUser
        };
        keepInputsSignIn.update((prevData) => [...prevData, data]);
        console.log(data);
        postInputsSignIn(data.email, data.password);
    }

    function handleSubmit(event: any) {
        event.preventDefault();
        keepUserInputs();
        goto('/home');
    }

    onMount(() => {
        keepUserInputs();
    });
</script>

<form class="connect" on:submit|preventDefault={handleSubmit}>
    <h2>Sign in</h2>
    <input bind:value={inputOneUser} type="email" placeholder="Entrez votre email">
    <input bind:value={inputTwoUser} type="password" placeholder="Entrez votre mot de passe">
    <button class="add" type="submit">Valider</button>
    <p><a href="/">Retour</a></p>
</form>
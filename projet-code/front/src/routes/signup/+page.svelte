<script lang="ts">
    import '../../assets/css/index.css';
    import { onMount } from 'svelte';
    import { keepInputsSignUp } from '../../lib/keepInputsSignUp';

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;
    let inputFourUser: string;
    let inputFiveUser: string;
    let inputSixUser: string;
    let inputSevenUser: string;
    let inputEightUser: number;

    function keepUserInputs() {
        let data = {
            id: 1,
            username: inputOneUser,
            email: inputTwoUser,
            password: inputThreeUser,
            firstname: inputFourUser,
            lastname: inputFiveUser,
            road: inputSixUser,
            city: inputSevenUser,
            zipcode: inputEightUser
        };
        keepInputsSignUp.update((prevData) => [...prevData, data]);
        console.log(data);
    }

    onMount(() => {
        keepUserInputs(); // Appeler la fonction lors du rendu initial
    });
</script>

<form class="connect" on:submit|preventDefault={keepUserInputs}>
    <h2>Sign up</h2>
    <input bind:value={inputOneUser} type="username" placeholder="Entrez votre nom d'utilisateur">
    <input bind:value={inputTwoUser} type="email" placeholder="Entrez votre email">
    <input bind:value={inputThreeUser} type="password" placeholder="Entrez votre mot de passe">
    <input bind:value={inputFourUser} type="firstname" placeholder="Entrez votre prénom">
    <input bind:value={inputFiveUser} type="lastname" placeholder="Entrez votre nom de famille">
    <input bind:value={inputSixUser} type="road" placeholder="Entrez votre numéro et rue">
    <input bind:value={inputSevenUser} type="city" placeholder="Entrez votre ville">
    <input bind:value={inputEightUser} type="zipcode" placeholder="Entrez votre code postal">
    <a href="/home"><button class="add" type="submit">Valider</button></a>
    <p><a href="/">Retour</a></p>
</form>
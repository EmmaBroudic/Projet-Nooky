<!--<script lang="ts">
    import '../../assets/css/index.css';
    import { onMount } from 'svelte';
    import { keepInputsProduct } from '../../lib/keepInputs';
    import { goto } from '$app/navigation';

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;

    function keepUserInputs() {
        let data = {
            id: 1,
            name: inputOneUser,
            description: inputTwoUser,
            picture: inputThreeUser
        };
        keepInputsProduct.update((prevData) => [...prevData, data]);
        console.log(data);
    }

    function handleSubmit(event: any) {
        event.preventDefault();
        keepUserInputs();
        goto('/account');
    }

    onMount(() => {
        keepUserInputs();
    });
</script>

<form class="connect" on:submit|preventDefault={handleSubmit}>
    <h2>Ajouter un produit</h2>
    <input bind:value={inputOneUser} type="name" placeholder="Entrez le nom du produit">
    <input bind:value={inputTwoUser} type="description" placeholder="Entrez la description du produit">
    <input bind:value={inputThreeUser} type="picture" placeholder="Entrez l'url de l'image'">
    <button class="add" type="submit">Valider</button>
    <p><a href="/account">Retour</a></p>
</form>-->
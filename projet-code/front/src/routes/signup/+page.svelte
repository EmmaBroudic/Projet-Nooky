<script lang="ts">
    import { onMount } from 'svelte';
    import Form from '../../components/Form/Form.svelte';

    let showFirstBlock = true;

    let inputs = [
        "username", "Entrez votre nom d'utilisateur",
        "email", "Entrez votre email",
        "password", "Entrez votre mot de passe",
        "firstname", "Entrez votre prénom",
        "lastname", "Entrez votre nom de famille",
        "road", "Entrez le numéro et le nom de votre rue",
        "zipcode", "Entrez votre code postal",
        "city", "Entrez votre ville"
    ];

    function toggleBlocks() {
        showFirstBlock = !showFirstBlock;
    }
</script>

{#if showFirstBlock}
    <Form inputOneData={inputs[0]} inputOne={inputs[1]} inputTwoData={inputs[2]} inputTwo={inputs[3]} inputThreeData={inputs[4]} inputThree={inputs[5]} inputFourData={inputs[6]} inputFour={inputs[7]} buttonClass="" buttonAction="Suivant" {/*myFunction={toggleBlocks}*/}/>
{:else}
    <Form inputOneData={inputs[8]} inputOne={inputs[9]} inputTwoData={inputs[10]} inputTwo={inputs[11]} inputThreeData={inputs[12]} inputThree={inputs[13]} inputFourData={inputs[14]} inputFour={inputs[15]} buttonClass="pink-border" buttonAction="Valider" {/*myFunction={toggleBlocks}*/}/>
{/if}
<script lang="ts">
    import { getUserByEmail } from '$lib/API/getFromAPI/getUserByEmail';
    import { postUser } from '$lib/API/postToAPI/postUser';

    import '../../assets/css/index.css';

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;
    let inputFourUser: string;
    let inputFiveUser: string;
    let inputSixUser: string;
    let inputSevenUser: string;
    let inputEightUser: string;

    let userData: any = {};

    let isSuccessVisible: boolean = false;
    let hasError: boolean = false;
    let hasErrorEmail: boolean = false;
    let hasErrorZipCode: boolean = false;
    let hasErrorUserExist: boolean = false;

    let submitted: boolean = false;

    const errorMessageVisible = "La validation n'a pas fonctionnée, le compte n'a pas été créé";
    const errorUserExist = "Une compte utilisateur avec cette adresse email existe déjà, veuillez vous connecter sur la page sign in"
    const errorEmail = "Email invalide";
    const errorZipCode = "Code postal invalide";

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const zipCodeRegex = /^[0-9]{5}$/;

    async function handleSubmit(event: any) {
        event.preventDefault();

        userData.username = inputOneUser;
        userData.email = inputTwoUser;
        userData.password = inputThreeUser;
        userData.firstname = inputFourUser;
        userData.lastname = inputFiveUser;
        userData.addressRoad = inputSixUser;
        userData.addressCity = inputSevenUser;
        userData.addressZipCode = inputEightUser;

        if (!emailRegex.test(inputTwoUser)) {
            hasErrorEmail = true;
        } else if (!zipCodeRegex.test(inputEightUser)) {
            hasErrorZipCode = true;
        } else {
            submitted = await postUser(userData);

            if (submitted === true) {
                isSuccessVisible = true;
            } else {
                hasError = true;
                const userExist = await getUserByEmail(inputTwoUser);
                if (userExist !== null) {
                    hasErrorUserExist = true;
                }
                console.log("La requête n'a pas fonctionné");
            }
        }
    }
</script>

<style>
    #redir-signin {
        display: flex;
        flex-direction: column;
        text-align: center;
        margin: 100px;
    }
</style>

{#if isSuccessVisible === false}
    <form class="connect" on:submit={handleSubmit}>
        
        <h2>Sign up</h2>
        
        <input bind:value={inputOneUser} type="username" placeholder="Entrez votre nom d'utilisateur" required>
        <input bind:value={inputTwoUser} type="email" placeholder="Entrez votre email" required>
        <input bind:value={inputThreeUser} type="password" placeholder="Entrez votre mot de passe" required>
        <input bind:value={inputFourUser} type="firstname" placeholder="Entrez votre prénom" required>
        <input bind:value={inputFiveUser} type="lastname" placeholder="Entrez votre nom de famille" required>
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
                <p><a href="/signin">Sign in</a></p>
            {/if}
        {/if}

        <p><a href="/connexion">Retour</a></p>
    </form>

{:else}
    <div id="redir-signin">
        <p>Votre compte a bien été créé, veuillez vous connecter en cliquant sur le lien ci-dessous :</p>
        <p><a href="/signin">Sign in</a></p>
    </div>
{/if}

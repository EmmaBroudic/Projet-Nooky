<script lang="ts">
    import { postUser } from '$lib/API/postToAPI/postUser';
    //import { postAddress } from '$lib/API/postToAPI/postAddress';
    //import { getAddressId } from '$lib/API/getFromAPI/getAddressId';

    import '../../assets/css/index.css';

    let inputOneUser: string;
    let inputTwoUser: string;
    let inputThreeUser: string;
    let inputFourUser: string;
    let inputFiveUser: string;
    let inputSixUser: string;
    let inputSevenUser: string;
    let inputEightUser: number;

    let addressData: any = {};
    let userData: any = {};

    //let formBoolean: boolean = false;
    //let validBoolean: boolean = false;

    async function handleSubmitUser(event: any) {
        event.preventDefault();

        userData.username = inputOneUser;
        userData.email = inputTwoUser;
        userData.password = inputThreeUser;
        userData.firstname = inputFourUser;
        userData.lastname = inputFiveUser;
        userData.addressRoad = inputSixUser;
        userData.addressCity = inputSevenUser;
        userData.addressZipCode = inputEightUser;
        //addressData.id = 1;

        console.log(userData);
        postUser(userData);
        //formBoolean = true;
    }

    /*async function handleSubmitAddress(event: any) {
        event.preventDefault();


        
        console.log(addressData);
        postAddress(addressData);
        validBoolean === true;
    }*/
</script>

<form class="connect" on:submit={handleSubmitUser}>
    <h2>Sign up</h2>
    <input bind:value={inputOneUser} type="username" placeholder="Entrez votre nom d'utilisateur">
    <input bind:value={inputTwoUser} type="email" placeholder="Entrez votre email">
    <input bind:value={inputThreeUser} type="password" placeholder="Entrez votre mot de passe">
    <input bind:value={inputFourUser} type="firstname" placeholder="Entrez votre prénom">
    <input bind:value={inputFiveUser} type="lastname" placeholder="Entrez votre nom de famille">
    <input bind:value={inputSixUser} type="road" placeholder="Entrez votre numéro et rue">
    <input bind:value={inputEightUser} type="zipcode" placeholder="Entrez votre code postal">
    <input bind:value={inputSevenUser} type="city" placeholder="Entrez votre ville">
    
    <button class="suivant" type="submit">Suivant</button>
    <p><a href="/">Retour</a></p>
</form>

    <!--<p>Votre compte a bien été créé, veuillez vous connecter en cliquant sur le lien ci-dessous :</p>
    <p><a href="/signin">Sign in</a></p>-->

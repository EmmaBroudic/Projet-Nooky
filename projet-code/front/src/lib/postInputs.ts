import { type InputsSignUp, type InputsSignIn } from './keepInputs';
import { fetchData } from './utils';

export async function postInputsSignUp() {
    const sendData = await fetchData("http://localhost:8080/user");
    let inputsSignUpData: InputsSignUp;

    console.log(sendData);
}

export async function postInputsSignIn(email: string, password: string) {
    //const sendData = await fetchData("http://localhost:8080/user");

    try {
        if (!email) {
            console.log("pas de data à envoyer");
        } else {
            console.log("data à envoyer" + email + password);
            JSON.stringify(email);
        }
    } catch(error) {
        console.error("Erreur lors de l\'insertion des données :", error)
    }

}


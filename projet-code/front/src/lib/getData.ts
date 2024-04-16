/*import { fetchData } from './utils';

export async function verifyInputsSignIn(email: string, password: string): Promise<boolean> {
    try {
        if (!email) {
            console.log("pas d'e-mail à vérifier");
            return false;
        }

        const getDataSignIn = await fetchData(`http://localhost:8080/user/email/${email}`);

        if (!getDataSignIn) {
            console.log("Aucune donnée trouvée pour l'e-mail spécifié");
            return false;
        }

        if (email === getDataSignIn.email && password === getDataSignIn.password) {
            console.log(getDataSignIn);
            return true;
        } else {
            console.log("Email ou mot de passe incorrect");
            return false;
        }
    } catch(error) {
        console.error("Erreur lors de la vérification des données :", error);
        return false;
    }
}*/

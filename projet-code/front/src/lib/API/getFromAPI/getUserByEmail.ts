import type { UserLogin } from '$lib/Objects/user';
import { saveUserId } from '../../utils';

export async function verifyInputsSignIn(email: string, password: string): Promise<boolean> {
// transformer la fonction pour récupérer un token
    try {
        const response = await fetch(`http://localhost:8080/users/email/${email}`);
        
        if (!response.ok) {
            throw new Error('La requête a échoué');
        }

        const data = await response.json();
        
        const user: UserLogin = {
            id: data.id,
            email: data.email,
            password: data.password
        }
        
        if (email === data.email && password !== data.password) {
            console.log("Email ou mot de passe incorrect");
            return false;
        } else {
            saveUserId(user.id);
            return true;
        }

    } catch (error) {
        console.error('Erreur lors de la requête:', error);
        return false;
    }
}
import { fetchData } from '../../utils';
import type { UserLogin } from '$lib/Objects/user';
import { saveUserId } from '../../utils';
import type { User } from '../../Objects/user';

export async function getUserByEmail(email: string) {
    const data = await fetchData(`http://localhost:8080/users/email/${email}`);

    const user: User = {
        id: data.id,
        email: data.email,
        username: data.username,
        picture: data.picture,
        description: data.description,
        firstname: data.firstname,
        lastname: data.lastname,
        createdAt: data.createdAt,
        city: data.addressCity
    }

    return user;
}

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
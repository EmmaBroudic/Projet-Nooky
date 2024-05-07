import { saveUserId } from '$lib/utils';
import type { UserLogin } from '../../Objects/user';

export async function postSignIn(user: UserLogin): Promise<boolean> {
    try {
        const response = await fetch("http://localhost:8080/users/auth", {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        });
            
        if (!response.ok) {
            throw new Error("Error fetching data from http://localhost:8080/users/auth");
        } else {
            console.log('Data sent');
            const token = await response.text();
            const payloadBase64 = token.split('.')[1]; // La charge utile est la deuxième partie du token, séparée par des points
            const payload = JSON.parse(atob(payloadBase64)); // Décoder la base64 et analyser la charge utile JSON
            const userId = payload.id; // Supposons que l'ID de l'utilisateur est stocké sous la clé "userId" dans la charge utile
            saveUserId(userId);
            localStorage.setItem('token', token); // Stocker le token dans le localStorage
            return true;
        }
    } catch (error) {
        console.error('Error posting:', error);
        return false;
    }
}
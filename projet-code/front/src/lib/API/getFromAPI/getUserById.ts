import { fetchData } from '../../utils';
import type { User } from '../../Objects/user';

export async function getUserById(id: any): Promise<User> {
    const data = await fetchData(`http://localhost:8080/users/id/${id}`);

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

    if (data.createdAt !== null) {
        const day = data.createdAt.toString().substr(8, 2);
        const month = data.createdAt.toString().substr(5, 2);
        const year = data.createdAt.toString().substr(0, 4);
        const date = data.createdAt.toString().substr(0, 10);
        user.createdAt = day + " " + month + " " + year;
    } else {
        user.createdAt = "";
    }

    if (data.picture === null) {
        user.picture = "https://www.apyart.com/1263-large_default/peinture-pour-artiste-gris-clair.jpg";
    }

    if (data.description === null) {
        user.description = "";
    }

    return user;
}

export async function getUserByIdBoolean(id: any): Promise<boolean> {
    try {
        const response = await fetch(`http://localhost:8080/users/id/${id}`);
        
        if (!response.ok) {
            throw new Error('La requête a échoué');
        }

        const data = await response.json();
        

        return data !== null;
    } catch (error) {
        console.error('Erreur lors de la requête:', error);
        return false;
    }
}
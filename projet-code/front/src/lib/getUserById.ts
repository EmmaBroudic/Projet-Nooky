import { fetchData } from './utils';
import type { User } from './user';

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

    console.log(user);
    return user;
}
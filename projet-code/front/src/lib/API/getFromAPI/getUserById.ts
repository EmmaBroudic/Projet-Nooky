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
        console.log(date);
        user.createdAt = day + " " + month + " " + year;
    } else {
        user.createdAt = "";
    }

    return user;
}
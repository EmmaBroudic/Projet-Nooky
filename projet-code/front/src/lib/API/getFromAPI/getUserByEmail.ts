import { fetchData } from '../../utils';
import type { UserEmail } from '../../Objects/user';

export async function getUserByEmail(email: string) {
    const data = await fetchData(`http://localhost:8080/users/email/${email}`);

    const user: UserEmail = {
        email: data.email,
    }

    return user;
}
import type { User } from '../../Objects/user';

export async function postUser(user: User): Promise<boolean> {
    try {
        const response = await fetch("http://localhost:8080/users", {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
                },
            body: JSON.stringify(user)
            });

            if (!response.ok) {
                throw new Error("Error fetching data from http://localhost:8080/users");
            } else {
                return true;
            }
        } catch (error) {
            return false;
        }
}
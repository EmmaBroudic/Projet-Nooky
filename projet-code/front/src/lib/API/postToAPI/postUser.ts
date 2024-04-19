import { postData } from '../../utils';
import type { User } from '../../Objects/user';

export async function postUser(user: User) {
    const url = 'http://localhost:8080/users';
    
    postData(url, user);
}
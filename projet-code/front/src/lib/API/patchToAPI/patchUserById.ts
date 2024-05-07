import { patchData } from '../../utils';

export async function patchUserById(id: any, data: any) {
    const url = `http://localhost:8080/users/id/${id}`;

    patchData(url, data);
}
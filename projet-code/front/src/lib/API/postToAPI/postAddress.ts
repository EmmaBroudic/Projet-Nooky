import { postData } from '../../utils';
import type { Address } from '../../Objects/address';

export async function postAddress(address: Address) {
    const url = 'http://localhost:8080/addresses';
    
    postData(url, address);
}
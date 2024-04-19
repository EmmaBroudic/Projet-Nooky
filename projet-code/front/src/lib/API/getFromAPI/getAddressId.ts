/*import { fetchData } from '../../utils';
import type { AddressId } from '../../Objects/address';

export async function getAddressId(road: string, city: string, zipCode: string): Promise<AddressId> {
    const data = await fetchData(`http://localhost:8080/addresses/${road}/${city}/${zipCode}`);

    const addressId: AddressId = {
        id: data.id
    }

    return addressId;
}*/
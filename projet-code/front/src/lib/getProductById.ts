import { fetchData } from './utils';
import type { Product } from './product';

export async function getProductById(id: any): Promise<Product> {
    const data = await fetchData(`http://localhost:8080/products/${id}`);

    const product: Product = {
        id: data.id,
        name: data.name,
        description: data.description,
        category: data.category,
        type: data.type,
        size: data.size,
        picture: data.picture,
        createdAt: data.createdAt,
        wishlist: data.wishlist,
        usernameOwner: data.usernameOwner
    }

    return product;
}
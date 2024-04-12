import { fetchData } from './utils';
import type { Product } from './product';

export async function getAllProducts(): Promise<Product[]> {
    const productList: Product[] = [];
    const url = 'http://localhost:8080/products/all';
    const dataProducts = await fetchData(url);

    dataProducts.forEach((dataProduct: any) => {
        const product: Product = {
            id: dataProduct.id,
            name: dataProduct.name,
            description: dataProduct.description,
            category: dataProduct.category,
            type: dataProduct.type,
            size: dataProduct.size,
            picture: dataProduct.picture,
            createdAt: dataProduct.createdAt,
            wishlist: dataProduct.wishlist,
            usernameOwner: dataProduct.usernameOwner
        };
        productList.push(product);
    });

    return productList;
}
import { fetchData } from '../../utils';
import type { Product } from '../../Objects/product';

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
            addedAt: dataProduct.addedAt,
            wishlist: dataProduct.wishlist,
            usernameOwner: dataProduct.usernameOwner
        };

        if (dataProduct.picture === null) {
            product.picture = "https://www.apyart.com/1263-large_default/peinture-pour-artiste-gris-clair.jpg";
        }

        productList.push(product);
    });

    return productList;
}
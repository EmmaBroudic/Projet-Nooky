import { fetchData } from '../../utils';
import type { ProductCard } from '../../Objects/productCard';

export async function getAllProductsByUserId(userId: any): Promise<ProductCard[]> {
    const productList: ProductCard[] = [];
    const url = `http://localhost:8080/products/all/user/${userId}`;
    const dataProducts = await fetchData(url);

    dataProducts.forEach((dataProduct: any) => {
        const product: ProductCard = {
            id: dataProduct.id,
            name: dataProduct.name,
            description: dataProduct.description,
            picture: dataProduct.picture,
        };

        if (dataProduct.name === null) {
            product.name = "Produit sans titre";
        }

        if (dataProduct.picture === null) {
            product.picture = "https://www.apyart.com/1263-large_default/peinture-pour-artiste-gris-clair.jpg";
        }

        if (dataProduct.description === null) {
            product.description = "Pas de description du produit";
        }

        productList.push(product);
    });

    return productList;
}
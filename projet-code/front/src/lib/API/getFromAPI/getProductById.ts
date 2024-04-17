import { fetchData } from '../../utils';
import type { Product } from '../../Objects/product';

export async function getProductById(id: any): Promise<Product> {
    const data = await fetchData(`http://localhost:8080/products/${id}`);

    const product: Product = {
        id: data.id,
        name: data.name,
        description: data.description,
        category: data.categoryLabel,
        type: data.typeLabel,
        size: data.sizeLabel,
        picture: data.picture,
        addedAt: data.addedAt,
        wishlist: data.wishlist,
        usernameOwner: data.userUsername
    }

    if (data.description === null) {
        product.description = "Pas de decription du produit";
    }

    if (data.picture === null) {
        product.picture = "https://www.apyart.com/1263-large_default/peinture-pour-artiste-gris-clair.jpg";
    }

   if (data.addedAt !== null) {
        const day = data.addedAt.toString().substr(8, 2);
        const month = data.addedAt.toString().substr(5, 2);
        const year = data.addedAt.toString().substr(0, 4);
        const date = data.addedAt.toString().substr(0, 10);
        console.log(date);
        product.addedAt = day + " " + month + " " + year;
    } else {
        product.addedAt = "";
    }

    if (data.wishlist === null) {
        product.wishlist = "";
    }

    return product;
}
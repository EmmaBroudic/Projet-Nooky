import { postData } from '../../utils';
import type { Product } from '../../Objects/product';

export async function postProduct(product: Product) {
    const url = 'http://localhost:8080/products';
    
    postData(url, product);
}
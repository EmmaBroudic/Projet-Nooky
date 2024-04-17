import { postData } from '../../utils';
import type { Product } from '../../Objects/product';

export async function postProduct(product: Product) {
    try {
        const response = await fetch('http://localhost:8080/products', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(product)
        });

        if (!response.ok) {
            throw new Error('Failed to post product');
        }
    } catch (error) {
        console.error('Error posting product:', error);
    }
}
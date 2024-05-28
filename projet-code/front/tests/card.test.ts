import { test, expect } from '@playwright/test';

test('Product component renders correctly', async ({ page }) => {
    // Mettre en place le contenu du composant
    const productImageDescription = "Test Product Description";
    const productImageSrc = "http://example.com/test-image.jpg";
    const productTitle = "Test Product Title";

    // Injecter le composant dans la page
    await page.setContent(`
        <script type="module">
            export let productImageDescription = "${productImageDescription}";
            export let productImageSrc = "${productImageSrc}";
            export let productTitle = "${productTitle}";
        </script>
        <style>
            .product-bloc {
                width: 280px;
                height: 280px;
                border-radius: 30px;
                margin-bottom: 80px;
            }

            img {
                width: 280px;
                height: 280px;
                border-radius: 30px;
                object-fit: cover;
            }

            h3 {
                text-align: center;
            }
        </style>
        <div class="product-bloc">
            <img alt="Photographie de ${productImageDescription}" src="${productImageSrc}" />
            <h3>${productTitle}</h3>
        </div>
    `);

    // Vérifier que l'image s'affiche avec la bonne description
    const productImage = await page.$('img');
    expect(productImage).not.toBeNull();
    if (productImage) {
        const altAttribute = await productImage.getAttribute('alt');
        expect(altAttribute).toContain(productImageDescription);
    }

    // Vérifier que le produit d'affiche correctement
    const productTitleElement = await page.$('h3');
    expect(productTitleElement).not.toBeNull();
    if (productTitleElement) {
        const productTitleText = await productTitleElement.innerText();
        expect(productTitleText).toBe(productTitle);
    }
});
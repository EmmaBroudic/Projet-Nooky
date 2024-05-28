import { test, expect } from '@playwright/test';

test('InfoBloc component renders correctly', async ({ page }) => {
    // Définir les valeurs des props pour le composant
    const blocTitle = "Test Bloc Title";
    const imgUrl = "http://example.com/test-image.jpg";
    const descriptionTitle = "Test Description Title";
    const infoOne = "Info One";
    const infoTwo = "Info Two";
    const infoThree = "Info Three";
    const infoFour = "Info Four";
    const infoFive = "Info Five";
    const infoSix = "http://example.com";

    // Injecter le composant dans la page
    await page.setContent(`
        <script type="module">
            export let blocTitle = "${blocTitle}";
            export let imgUrl = "${imgUrl}";
            export let descriptionTitle = "${descriptionTitle}";
            export let infoOne = "${infoOne}";
            export let infoTwo = "${infoTwo}";
            export let infoThree = "${infoThree}";
            export let infoFour = "${infoFour}";
            export let infoFive = "${infoFive}";
            export let infoSix = "${infoSix}";
        </script>
        <style>
            /* Styles du composant ici */
        </style>
        <div id="bloc-info">
            <h2>${blocTitle}</h2>
            <div class="bloc">
                <img src="${imgUrl}" alt="photographie de ${descriptionTitle}" />
                <div class="bloc-right">
                    <div class="description">
                        <h3>${descriptionTitle}</h3>
                        <p>${infoOne}</p>
                        <p>${infoTwo}</p>
                        <p>${infoThree}</p>
                        <a href="${infoSix}"><p>${infoFour}</p></a>
                        <p>${infoFive}</p>
                    </div>
                </div>
            </div>
        </div>
    `);

    // Vérifier si le titre du bloc est rendu correctement
    const blocTitleElement = await page.$('h2');
    expect(blocTitleElement).not.toBeNull();
    if (blocTitleElement) {
        const blocTitleText = await blocTitleElement.innerText();
        expect(blocTitleText).toBe(blocTitle);
    }

    // Vérifier si l'image est rendue correctement avec la description correcte
    const imgElement = await page.$('img');
    expect(imgElement).not.toBeNull();
    if (imgElement) {
        const imgAlt = await imgElement.getAttribute('alt');
        expect(imgAlt).toContain(descriptionTitle);
    }

    // Vérifier si le titre de description est rendu correctement
    const descriptionTitleElement = await page.$('h3');
    expect(descriptionTitleElement).not.toBeNull();
    if (descriptionTitleElement) {
        const descriptionTitleText = await descriptionTitleElement.innerText();
        expect(descriptionTitleText).toBe(descriptionTitle);
    }

    // Vérifier si chaque information est rendue correctement
    const infoOneElement = await page.$('p:has-text("' + infoOne + '")');
    expect(infoOneElement).not.toBeNull();

    const infoTwoElement = await page.$('p:has-text("' + infoTwo + '")');
    expect(infoTwoElement).not.toBeNull();

    const infoThreeElement = await page.$('p:has-text("' + infoThree + '")');
    expect(infoThreeElement).not.toBeNull();

    // Vérifier si le lien est rendu correctement avec le texte correct
    const infoFourElement = await page.$('a[href="' + infoSix + '"]');
    expect(infoFourElement).not.toBeNull();
    if (infoFourElement) {
        const infoFourText = (await infoFourElement.innerText()).trim(); // Utiliser trim() pour supprimer les espaces blancs
        expect(infoFourText).toBe(infoFour);
    }

    const infoFiveElement = await page.$('p:has-text("' + infoFive + '")');
    expect(infoFiveElement).not.toBeNull();
});
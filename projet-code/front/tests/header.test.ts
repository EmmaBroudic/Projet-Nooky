import { test, expect } from '@playwright/test';

test.describe('Header Component', () => {
  test.beforeEach(async ({ page }) => {
    // Navigue vers la page contenant le composant header
    await page.goto('http://localhost:5173');
    // Attend que le composant header soit visible
    await page.waitForSelector('header');
  });

  test('should display the logo and title correctly', async ({ page }) => {
    // Vérifie que le logo est affiché correctement
    const logoSrc = await page.getAttribute('header img', 'src');
    expect(logoSrc).not.toBeNull();

    // Vérifie que le titre est affiché correctement
    const titleText = await page.textContent('header h1');
    expect(titleText).toContain('Nooky');

    // Vérifie que la description est affichée correctement
    const descriptionText = await page.textContent('header p');
    expect(descriptionText).toContain('Échange des vêtements, chaussures et accessoires de seconde main');
  });

  test('should display the navigation links correctly', async ({ page }) => {
    // Vérifie que les liens de navigation sont affichés correctement
    const navLinks = await page.$$('header nav a');
    expect(navLinks.length).toBeGreaterThan(0);

    // Vérifie que le lien "Home" est présent
    const homeLink = await page.textContent('header nav a.menu-left');
    expect(homeLink).toContain('Home');

    // Vérifie que le lien "Log in" est présent pour les utilisateurs non connectés
    const loginLink = await page.textContent('header nav a.menu-right');
    expect(loginLink).toContain('Log in');
  });
});
export async function handle(event: any, resolve: any) {

    const token = localStorage.getItem("token");

    // Définir les routes protégées
    const protectedRoutes = ['/modifyaccount', '/addproduct', '/modifyproduct/[id]'];

    if (protectedRoutes.includes(event.url.pathname)) {
        if (!token) {
            // Rediriger vers la page d'erreur
            return new Response(null, {
                status: 302,
                headers: {
                    Location: '/error'
                }
            });
        }
    }

    // Continuer avec la requête
    return resolve(event);
}
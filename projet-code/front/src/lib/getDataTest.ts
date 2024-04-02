export async function verifyInputsToken(user: string, password: string): Promise<any> {
    
    fetch("http://localhost:8080/login", {
        method: 'POST',
        mode: "cors",
        credentials: "same-origin",
        body: JSON.stringify({ user: user, password: password }),
        headers: { 'Content-Type': 'application/json' }//,
        //mode: 'no-cors'
        })
  
        // passer les données au format JSON
        .then(response => response.json())
  
        // comparer les données utilisateur
        .then(data => {
          
          // tester sur la console la récupération des données
          console.log(data);
          console.log(user);
          console.log(password);
          
          // si les données sont les bonnes, connexion réussie
          if (data.token) {
            // affichage du message pour l'utilisateur
            alert("Connexion réussie !");
            
            // conserver les données dans le local storage
            window.localStorage.setItem("token", data.token);
            
            console.log(data.userId);
            console.log(data.token);
            
            // Si les données utilisateurs sont incorrectes, lui indiquer par un message
            } else {
            alert("Identifiants incorrects.");
            }
        })
        
        // Gérer les erreurs
        .catch(error => console.error(error));
    
    /*try {
        if (!token) {
            console.log("pas d'e-mail à vérifier");
            return false;
        }

        const getDataSignIn = await fetchData(`http://localhost:8080/${token}`);

        if (!getDataSignIn) {
            console.log("Aucune donnée trouvée pour l'e-mail spécifié");
            return false;
        }

       /* if (email === getDataSignIn.email && password === getDataSignIn.password) {
            console.log(getDataSignIn);
            return true;
        } else {
            console.log("Email ou mot de passe incorrect");
            return false;
        }*/
    /*} catch(error) {
        console.error("Erreur lors de la vérification des données :", error);
        return false;
    }*/
}
export interface User {
    id: number;
    email: string;
    username: string;
    picture: string;
    description: string;
    firstname: string;
    lastname: string;
    createdAt: any;
    city: string;
}

// à modifier lors de la sécurisation de l'appli
export interface UserLogin {
    id: number,
    email: string,
    password: string
}
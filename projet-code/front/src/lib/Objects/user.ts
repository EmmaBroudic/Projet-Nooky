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

export interface UserLogin {
    email: string,
    password: string
}

export interface UserEmail {
    email: string;
}
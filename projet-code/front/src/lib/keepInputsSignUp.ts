import { writable } from "svelte/store";

interface InputsSignUp {
    id: number;
    username: string;
    email: string;
    password: string;
    firstname: string;
    lastname: string;
    road: string;
    city: string;
    zipcode: number;
}

export const keepInputsSignUp = writable<InputsSignUp[]>([]);
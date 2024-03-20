<script lang="ts">
    import '../../assets/css/index.css';
    import { onMount } from 'svelte';

    export let inputOneData: string;
    export let inputOne: string;
    export let inputTwoData: string;
    export let inputTwo: string;
    export let inputThreeData: string;
    export let inputThree: string;
    export let inputFourData: string;
    export let inputFour: string;
    export let buttonClass: string;
    export let buttonAction: string;
    export let myFunction: () => void;

    onMount(() => {
        myFunction();
    });

    function handleClick() {
        myFunction();
    }
</script>

<style>
    .connect {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }
</style>

<form class="connect">
    <h2>Sign up</h2>
    <input type={inputOneData} placeholder={inputOne}>
    <input type={inputTwoData} placeholder={inputTwo}>
    <input type={inputThreeData} placeholder={inputThree}>
    <input type={inputFourData} placeholder={inputFour}>
    <button on:click={handleClick} class={buttonClass}>{buttonAction}</button>
</form>
<script lang="ts">
    import Search from '../Searchbar/Searchbar.svelte';
    import logo from '../../assets/images/husky.jpg';
    import '../../assets/css/index.css';
    import { getUserId } from '$lib/utils';
    import { onMount } from 'svelte';

    let userId: any;
    onMount(() => {
        userId = getUserId();
    });
</script>

<style>
    header {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        padding-bottom: 45px;
        border-bottom: 3px solid pink;
        width: 100%;
        height: 180px;
    }

    .header-left {
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
    }

    .header-right {
        display: flex;
        flex-direction: column;
    }

    .title {
        display: flex;
        flex-direction: column;
        padding-top: 75px;
        padding-left: 30px;
    }

    img {
        padding-top: 50px;
        padding-left: 50px;
        width: 100px;
        height: auto;
    }

    nav {
        display: flex;
        flex-direction: row;
        justify-content: right;
        padding-top: 60px;
        padding-right: 30px;
    }

    .menu-left, .menu-right {
        font-family: Montserrat;
        font-size: 14px;
        color: black;
        text-decoration: none;
        padding-right: 30px;
    }

    .menu-left:hover, .menu-right:hover {
        font-family: Montserrat;
        font-size: 14px;
        color: black;
        text-decoration: underline;
        cursor: pointer;
    }
</style>

{#if userId != null}
    <header>
        <div class="header-left">
            <img src={logo} class="header-logo" alt="logo funky" />
            <div class="title">
                <h1>Nooky</h1>
                <p>Échange des vêtements, chaussures et accessoires de seconde main</p>
            </div>
        </div>
        <div class="header-right">
            <nav>
                <a href="/home" class:menu-left={true}>Home</a>
                <a href="/account/{userId}/" class:menu-left={true}>Mon compte</a>
                <a href="/signin" class:menu-right={true}>Log out</a>
            </nav>
            <Search />
        </div>
    </header>
{:else}
    <header>
        <div class="header-left">
            <img src={logo} class="header-logo" alt="logo funky" />
            <div class="title">
                <h1>Nooky</h1>
                <p>Échange des vêtements, chaussures et accessoires de seconde main</p>
            </div>
        </div>
        <div class="header-right">
            <nav>
                <a href="/home" class:menu-left={true}>Home</a>
                <a href="/" class:menu-right={true}>Log in</a>
            </nav>
            <Search />
        </div>
    </header>
{/if}

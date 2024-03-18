<script lang="ts">
    import Search from '../Searchbar/Searchbar.svelte';
    import logo from '../../assets/images/husky.jpg';
    import '../../assets/css/index.css';
</script>

<style>
    @font-face {
        font-family: 'Montserrat';
        src: url('../../assets/fonts/Montserrat-Medium.ttf') format('truetype');
    }

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

    .menu-left.active, .menu-right.active {
        text-decoration: underline;
    }
</style>

<header>
    <div class="header-left">
        <img src={logo} class="header-logo" alt="logo funky" />
        <div class="title">
            <h1>Nooky</h1>
            <p>Échange de la seconde main avec ta communauté</p>
        </div>
    </div>
    <div class="header-right">
        <nav>
            <a href="/home" class:menu-left={true} class:active={true}>Home</a>
            <a href="/account" class:menu-left={true} class:active={true}>Mon compte</a>
            <a href="/notifications" class:menu-left={true} class:active={true}>Notifications</a>
            <a href="/login" class:menu-right={true} class:active={true}>Log out</a>
        </nav>
        <Search />
    </div>
</header>
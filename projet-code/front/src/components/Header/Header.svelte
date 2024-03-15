<script lang="ts">
    import Search from '../Searchbar/Searchbar.svelte';
    import logo from '../../assets/images/husky.jpg';
</script>

<style>
    @font-face {
        font-family: 'MontserratLight';
        src: url('../../assets/fonts/Montserrat-Light.ttf') format('truetype');
    }

    @font-face {
        font-family: 'Montserrat';
        src: url('../../assets/fonts/Montserrat-Medium.ttf') format('truetype');
    }

    @font-face {
        font-family: 'MontserratBold';
        src: url('../../assets/fonts/Montserrat-Bold.ttf') format('truetype');
    }

    header {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 100%;
        height: 180px;
    }

    .header-left {
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
        /*align-items: center;  ajouté pour aligner verticalement */
    }

    .header-right { /* correction du nom de la classe */
        display: flex;
        flex-direction: column;
        /*justify-content: flex-end;
        /* align-items: center; ajouté pour aligner verticalement */
    }

    .title {
        display: flex;
        flex-direction: column;
        padding-top: 75px;
        padding-left: 30px;
    }

    h1 {
        font-family: MontserratBold;
        font-size: 20pt;
    }

    p {
        font-family: Montserrat;
        font-size: 10pt;
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
        /* aalign-items: center; jouté pour aligner verticalement */
        padding-top: 60px;
        padding-right: 30px;
    }

    .menu-left, .menu-right {
        font-family: Montserrat;
        font-size: 10pt;
        color: black;
        text-decoration: none;
        padding-right: 30px;
    }

    .menu-left:hover, .menu-right:hover {
        font-family: Montserrat;
        font-size: 10pt;
        color: black;
        text-decoration: underline;
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
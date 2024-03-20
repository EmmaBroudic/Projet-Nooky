<script lang="ts">
    import '../../assets/css/index.css';
</script>

<style>
    a {
        text-decoration: none;
    }

    .connect {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }
</style>

<form class="connect">
    <h2>Sign in</h2>
    <input type="identifiant" placeholder="Entrez votre identifiant">
    <input type="email" placeholder="Entrez votre email">
    <button class="pink-border"><a href="/home">Valider</a></button>
    <p><a href="/">Retour</a></p>
</form>
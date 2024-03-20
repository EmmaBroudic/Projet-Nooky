<script lang="ts">
    export let blocTitle: string;
    export let imgUrl: string;
    export let descriptionTitle: string;
    export let buttonText: string;
    export let descriptionText: string;
</script>

<style>
    .bloc {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin: 20px;
    }

    img {
        width: 300px;
        height: 300px;
        border-radius: 30px;
        object-fit: cover;
        margin-left: 30px;
        margin-right: 30px;
        margin-bottom: 30px;
    }

    .description {
        width: 800px;
        margin-left: 30px;
        margin-right: 30px;
        margin-bottom: 30px;
        background-color: #f6f6f6;
        height: 240px;
        border-radius: 30px;
        padding: 30px;
    }

    h2 {
        margin-top: 50px;
        margin-left: 70px;
    }

    .bloc-right {
        display: flex;
        flex-direction: column;
        justify-content: flex-end;
    }

    button {
        margin-left: auto;
        margin-right: 30px;
    }
</style>

<h2>{blocTitle}</h2>
<div class="bloc">
    <img src={imgUrl} alt="portrait profil" />
    <div class="bloc-right">
        <div class="description">
            <h3>{descriptionTitle}</h3>
            <p>{descriptionText}</p>
        </div>
        <button class="modify">{buttonText}</button>
    </div>
</div>
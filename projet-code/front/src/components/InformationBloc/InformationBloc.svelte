<script lang="ts">
    import '../../assets/css/index.css';

    export let blocTitle: string;
    export let imgUrl: string;
    export let descriptionTitle: string;
    export let infoOne: string;
    export let infoTwo: string;
    export let infoThree: string;
    export let infoFour: string;
    export let infoFive: string;
    export let infoSix: string;
</script>

<style>

    @media screen and (min-width: 1110px) {
        #bloc-info {
            display: flex;
            flex-direction: column;
            width: 100%;
        }

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

        .bloc-right {
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
        }

        .description {
            width: 90%;
            min-width: 600px;
            margin-right: 50px;
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
    }
    @media screen and (min-width: 820px) and (max-width: 1109px) {
        .bloc {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin: 20px;
        }

        img {
            width: 300px;
            height: auto;
            border-radius: 30px;
            object-fit: cover;
            margin-left: 20px;
            margin-right: 20px;
            margin-bottom: 30px;
        }

        .bloc-right {
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
        }

        .description {
            width: 80%;
            min-width: 260px;
            margin-left: 20px;
            margin-right: 20px;
            margin-bottom: 30px;
            background-color: #f6f6f6;
            height: 300px;
            border-radius: 30px;
            padding: 30px;
        }

        h2 {
            margin-top: 50px;
            margin-left: 70px;
        }
    }
    @media screen and (max-width: 819px) {
        .bloc {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-between;
            margin: 20px;
        }

        img {
            width: 370px;
            height: 370px;
            border-radius: 30px;
            object-fit: cover;
            margin-bottom: 30px;
        }

        .bloc-right {
            display: flex;
            flex-direction: column;
        }

        .description {
            width: 310px;
            margin-bottom: 30px;
            background-color: #f6f6f6;
            height: auto;
            border-radius: 30px;
            padding: 30px;
            text-align: center;
        }

        h2 {
            margin-top: 50px;
            text-align: center;
        }
    }
</style>

<div id="bloc-info">
    <h2>{blocTitle}</h2>
    <div class="bloc">
        <img src={imgUrl} alt={"photographie de " + descriptionTitle} />
        <div class="bloc-right">
            <div class="description">
                <h3>{descriptionTitle}</h3>
                <p>{infoOne}</p>
                <p>{infoTwo}</p>
                <p>{infoThree}</p>
                <a href={infoSix}><p>{infoFour}</p></a>
                <p>{infoFive}</p>
            </div>
        </div>
    </div>
</div>
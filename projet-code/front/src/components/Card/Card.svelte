<script lang="ts">
    export let productImageDescription: string;
    export let productImageSrc: string;
    export let productTitle: string;
</script>

<style>
    .product-bloc {
        width: 300px;
        height: 300px;
        border-radius: 30px;
        margin-bottom: 80px;
    }

    img {
        width: 300px;
        height: 300px;
        border-radius: 30px;
        object-fit: cover;
    }

    h3 {
        text-align: center;
    }
</style>

<div class="product-bloc">
    <img alt={"Photographie de " + productImageDescription} src={productImageSrc} />
    <h3>{productTitle}</h3>
</div>


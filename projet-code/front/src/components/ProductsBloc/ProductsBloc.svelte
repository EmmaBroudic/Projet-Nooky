<script lang="ts">
    import ProductCard from '../../components/ProductCard/ProductCard.svelte';
</script>

<style>
.products-bloc {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-around;
    margin-left: 50px;
    margin-right: 50px;
}
</style>

<div class="products-bloc">
    <ProductCard productImageSrc="https://www.minelli.fr/fstrz/r/s/www.minelli.fr/dw/image/v2/BCLB_PRD/on/demandware.static/-/Sites-MIN-master-catalog/default/dw6baaeeaf/images/F930003LIS_ROSE_B.jpg?sw=595&sh=660&sm=fit" productImageDescription="chaussures roses" productTitle="chaussures roses"/>
    <ProductCard productImageSrc="https://www.chaussure-de-danse.com/wp-content/uploads/2015/12/20151205_112645.jpg" productImageDescription="chaussures roses" productTitle="chaussures roses"/>
    <ProductCard productImageSrc="https://www.luciferonyou.fr/cdn/shop/products/Screenshot_20210529_135820_com.alibaba.aliexpresshd_edit_230915686729868.jpg?v=1622298512" productImageDescription="robe noire" productTitle="robe noire"/>
    <ProductCard productImageSrc="https://image1.superdry.com/static/images/optimised/zoom/upload9223368955666135084.jpg" productImageDescription="jean large" productTitle="jean large"/>
    <ProductCard productImageSrc="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj3BFYM029523pu11inZOKFM9wAs61o2dNhudso9wCF3Pq1LQ84n3-T2aTEX-sO7gnbk0&usqp=CAU" productImageDescription="chapeau de paille" productTitle="chapeau de paille"/>
    <ProductCard productImageSrc="https://www.luciferonyou.fr/cdn/shop/products/Screenshot_20210529_135820_com.alibaba.aliexpresshd_edit_230915686729868.jpg?v=1622298512" productImageDescription="robe noire" productTitle="robe noire"/>
    <ProductCard productImageSrc="https://www.chaussure-de-danse.com/wp-content/uploads/2015/12/20151205_112645.jpg" productImageDescription="chaussures roses" productTitle="chaussures roses"/>
    <ProductCard productImageSrc="https://www.luciferonyou.fr/cdn/shop/products/Screenshot_20210529_135820_com.alibaba.aliexpresshd_edit_230915686729868.jpg?v=1622298512" productImageDescription="robe noire" productTitle="robe noire"/>
    <ProductCard productImageSrc="https://www.chaussure-de-danse.com/wp-content/uploads/2015/12/20151205_112645.jpg" productImageDescription="chaussures roses" productTitle="chaussures roses"/>
</div>
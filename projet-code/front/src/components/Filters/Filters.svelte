<script lang="ts">
    import { getAllCategories, getAllSizes, getAllTypes } from "$lib/API/getFromAPI/getAllReferantialData";
    import type { Category } from '$lib/Objects/category.ts';
    import type { Type } from '$lib/Objects/type.ts';
    import type { Size } from '$lib/Objects/size.ts';
    import '../../assets/css/index.css';
    import { onMount } from "svelte";

    let checked: boolean = false;

    let categoryList: Category[] = [];
    let typeList: Type[] = [];
    let sizeList: Size[] = [];

    onMount(async () => {
        categoryList = await getAllCategories();
        typeList = await getAllTypes();
        sizeList = await getAllSizes();
    });
</script>

<style>
    #filter-bloc {
        width: 170px;
        height: auto;
        background-color: #f6f6f6;
        border-radius: 30px;
        padding: 30px;
    }

    .filter {
      display: flex;
      flex-direction: row;
      margin: 0;
    }

    .filter-check {
      width: 20px;
      height: 20px;
    }
</style>

<div id="filter-bloc">
    <h4>Catégories</h4>
    {#each categoryList as item (item.id)}
        <div class="filter">
          <input class="filter-check" type="checkbox" bind:checked={checked} value={item.id}>
          <p>{item.label}</p>
        </div>
    {/each}

    <h4>Types</h4>
    {#each typeList as item (item.id)}
        <div class="filter">
          <input class="filter-check" type="checkbox" bind:checked={checked} value={item.id}>
          <p>{item.label}</p>
        </div>
    {/each}
</div>
<!--    <li>
    {#each sizeList as item (item.id)}
        <input type="checkbox" bind:checked={item.label} value={item.id} />
    {/each}
    </li>
    <li>
    {#each typeList as item (item.id)}
        <input type="checkbox" bind:checked={item.label} value={item.id} />
    {/each}
    </li>-->
    <!--<script>
        let items = [
          { id: 1, text: "Faire les courses", completed: false },
          { id: 2, text: "Faire du sport", completed: true },
          { id: 3, text: "Lire un livre", completed: false }
        ];
      
        function toggleCompletion(id) {
          items = items.map(item =>
            item.id === id ? { ...item, completed: !item.completed } : item
          );
        }
      </script>-->
      
      <!--<ul>
        {#each items as { id, text, completed }}
          <li>
            <input type="checkbox" bind:checked={completed} on:change={() => toggleCompletion(id)} />
            <label>{text}</label>
          </li>
        {/each}
      </ul>-->
<script lang="ts">

    /*export let id: number;
    export let name: String;*/
    export let items: any[] = [];
    export let title: string;
    export let inputUser: any;

	/*let cats = [
		{ id: 1, name: 'Keyboard Cat' },
		{ id: 2, name: 'Maru' },
		{ id: 3, name: 'Henri The Existential Cat' }
	];*/
</script>

<h1>{title}</h1>

<ul>
	{#each items as item}
		<li>
			{ item.id }
            { item.name }
		</li>
        <input bind:value={inputUser} placeholder={ item.name }>
	{/each}
</ul>
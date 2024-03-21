<script lang="ts">
    import FormTest from '../../components/FormTest/FormTest.svelte';

    let inputUser: string;

	let cats = [
		{ id: 1, name: 'Keyboard Cat' },
		{ id: 2, name: 'Maru' },
		{ id: 3, name: 'Henri The Existential Cat' }
	];

</script>

<FormTest inputUser={inputUser} items={cats} title="great cats"/>
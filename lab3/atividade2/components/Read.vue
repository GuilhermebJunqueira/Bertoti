<template>
  <div>
    <h2>Read Pokémon</h2>
    <ul>
      <li v-for="pokemon in pokemons" :key="pokemon.name">{{ pokemon.name }} - {{ pokemon.type }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pokemons: [
        { name: 'Pikachu', type: 'Elétrico' },
        { name: 'Bulbasaur', type: 'Planta' }
      ]
    };
  }
};
</script>

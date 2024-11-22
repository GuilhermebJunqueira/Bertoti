<template>
  <div>
    <h2>Create Pokémon</h2>
    <input v-model="newPokemon.name" placeholder="Nome do Pokémon" />
    <input v-model="newPokemon.type" placeholder="Tipo do Pokémon" />
    <button @click="savePokemon">Salvar</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newPokemon: {
        name: '',
        type: ''
      }
    };
  },
  methods: {
    savePokemon() {
      alert(`Pokémon ${this.newPokemon.name} criado com sucesso!`);
    }
  }
};
</script>

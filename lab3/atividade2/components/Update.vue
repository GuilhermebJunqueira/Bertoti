<template>
  <div>
    <h2>Update Pokémon</h2>
    <input v-model="updateData.name" placeholder="Nome do Pokémon (para buscar)" />
    <input v-model="updateData.newType" placeholder="Novo Tipo" />
    <button @click="saveUpdatedPokemon">Atualizar</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      updateData: {
        name: '',
        newType: ''
      }
    };
  },
  methods: {
    saveUpdatedPokemon() {
      alert(`Pokémon ${this.updateData.name} atualizado para o tipo ${this.updateData.newType}`);
    }
  }
};
</script>

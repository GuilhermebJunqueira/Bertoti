<template>
  <div>
    <h2>Delete Pokémon</h2>
    <input v-model="deleteName" placeholder="Nome do Pokémon para deletar" />
    <button @click="deletePokémon">Deletar</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      deleteName: ''
    };
  },
  methods: {
    deletePokémon() {
      alert(`Pokémon ${this.deleteName} deletado com sucesso!`);
    }
  }
};
</script>

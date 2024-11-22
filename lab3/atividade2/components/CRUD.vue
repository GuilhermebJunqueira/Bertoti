<template>
  <div>
    <h1>Pokémon CRUD</h1>

    <!-- Botões de CRUD -->
    <button @click="createPokemon" class="crud-button">Create</button>
    <button @click="readPokemons" class="crud-button">Read</button>
    <button @click="updatePokemon" class="crud-button">Update</button>
    <button @click="deletePokemon" class="crud-button">Delete</button>

    <!-- Formulário de criação -->
    <div v-if="isCreating">
      <h2>Create Pokémon</h2>
      <input v-model="newPokemon.name" placeholder="Nome do Pokémon" />
      <input v-model="newPokemon.type" placeholder="Tipo do Pokémon" />
      <button @click="savePokemon">Salvar</button>
    </div>

    <!-- Lista de Pokémons cadastrados -->
    <div v-if="pokemons.length > 0">
      <h2>Pokémons Cadastrados</h2>
      <ul>
        <li v-for="pokemon in pokemons" :key="pokemon.name">
          {{ pokemon.name }} - {{ pokemon.type }}
        </li>
      </ul>
    </div>

    <!-- Formulário de atualização -->
    <div v-if="isUpdating">
      <h2>Atualizar Pokémon</h2>
      <input v-model="updateData.name" placeholder="Nome do Pokémon (para buscar)" />
      <input v-model="updateData.newType" placeholder="Novo Tipo" />
      <button @click="saveUpdatedPokemon">Atualizar</button>
    </div>

    <!-- Formulário de exclusão -->
    <div v-if="isDeleting">
      <h2>Deletar Pokémon</h2>
      <input v-model="deleteName" placeholder="Nome do Pokémon para deletar" />
      <button @click="deletePokémon">Deletar</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pokemons: [],
      newPokemon: { name: "", type: "" },
      updateData: { name: "", newType: "" },
      deleteName: "",
      isCreating: false,
      isUpdating: false,
      isDeleting: false,
    };
  },
  methods: {
    // Create - Adiciona Pokémon
    createPokemon() {
      this.isCreating = true;
      this.isUpdating = false;
      this.isDeleting = false;
    },
    savePokemon() {
      if (this.newPokemon.name && this.newPokemon.type) {
        this.pokemons.push({ ...this.newPokemon });
        this.newPokemon = { name: "", type: "" }; // Limpa após salvar
        alert('Pokémon criado com sucesso!');
      } else {
        alert('Por favor, preencha ambos os campos!');
      }
    },

    // Read - Mostra os Pokémons
    readPokemons() {
      this.isCreating = false;
      this.isUpdating = false;
      this.isDeleting = false;
    },

    // Update - Modifica Pokémon
    updatePokemon() {
      this.isCreating = false;
      this.isUpdating = true;
      this.isDeleting = false;
    },
    saveUpdatedPokemon() {
      const pokemon = this.pokemons.find(p => p.name === this.updateData.name);
      if (pokemon) {
        pokemon.type = this.updateData.newType;
        this.updateData = { name: "", newType: "" }; // Limpa após atualizar
        alert('Pokémon atualizado com sucesso!');
      } else {
        alert('Pokémon não encontrado!');
      }
    },

    // Delete - Exclui Pokémon
    deletePokemon() {
      this.isCreating = false;
      this.isUpdating = false;
      this.isDeleting = true;
    },
    deletePokémon() {
      const index = this.pokemons.findIndex(p => p.name === this.deleteName);
      if (index !== -1) {
        this.pokemons.splice(index, 1);
        this.deleteName = ""; // Limpa após excluir
        alert('Pokémon deletado com sucesso!');
      } else {
        alert('Pokémon não encontrado!');
      }
    },
  },
};
</script>

<style scoped>
.crud-button {
  display: inline-block;
  padding: 10px 20px;
  margin: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
}

.crud-button:hover {
  background-color: #35495e;
}

input {
  padding: 10px;
  margin: 5px;
  border-radius: 5px;
}
</style>

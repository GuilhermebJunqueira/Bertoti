<template>
  <div>
    <h1>Pokémon CRUD</h1>

    <!-- Botões de CRUD -->
    <button @click="goToCreate" class="crud-button">Create</button>
    <button @click="goToRead" class="crud-button">Read</button>
    <button @click="goToUpdate" class="crud-button">Update</button>
    <button @click="goToDelete" class="crud-button">Delete</button>
  </div>
</template>

<script>
export default {
  methods: {
    goToCreate() {
      this.$router.push('/create'); // Redireciona para a página Create
    },
    goToRead() {
      this.$router.push('/read'); // Redireciona para a página Read
    },
    goToUpdate() {
      this.$router.push('/update'); // Redireciona para a página Update
    },
    goToDelete() {
      this.$router.push('/delete'); // Redireciona para a página Delete
    }
  }
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
</style>

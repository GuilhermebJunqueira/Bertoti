<template>
  <div id="app">
    <h1>Bem-vindo ao Pokémon Frontend!</h1>

    <!-- Botões de navegação -->
    <router-link to="/create" class="nav-button">Create</router-link>
    <router-link to="/read" class="nav-button">Read</router-link>
    <router-link to="/update" class="nav-button">Update</router-link>
    <router-link to="/delete" class="nav-button">Delete</router-link>

    <!-- O conteúdo das páginas será exibido aqui -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style scoped>
.nav-button {
  display: inline-block;
  padding: 10px 20px;
  margin: 10px;
  background-color: #42b983;
  color: white;
  text-decoration: none;
  border-radius: 5px;
  font-size: 16px;
}

.nav-button:hover {
  background-color: #35495e;
}
</style>

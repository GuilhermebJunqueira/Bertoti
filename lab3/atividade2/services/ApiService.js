import axios from 'axios';

const API_URL = 'http://localhost:8080/api';  // Ajuste a URL para o seu backend

export default {
    getAll() {
        return axios.get(`${API_URL}/pokemons`);
    },

    get(id) {
        return axios.get(`${API_URL}/pokemons/${id}`);
    },

    create(pokemon) {
        return axios.post(`${API_URL}/pokemons`, pokemon);
    },

    update(id, pokemon) {
        return axios.put(`${API_URL}/pokemons/${id}`, pokemon);
    },

    delete(id) {
        return axios.delete(`${API_URL}/pokemons/${id}`);
    },
};

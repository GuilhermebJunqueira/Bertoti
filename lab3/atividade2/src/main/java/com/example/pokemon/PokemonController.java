package com.example.pokemon;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private List<Pokemon> pokemons = new ArrayList<>();

    @PostMapping
    public Pokemon create(@RequestBody Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon;
    }

    @GetMapping
    public List<Pokemon> read() {
        return pokemons;
    }

    @PutMapping("/{id}")
    public Pokemon update(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        // Lógica de atualização
        return pokemon;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Lógica de remoção
    }
}

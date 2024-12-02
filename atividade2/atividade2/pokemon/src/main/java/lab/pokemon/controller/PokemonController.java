package lab.pokemon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lab.pokemon.model.Pokemon;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    private final List<Pokemon> pokemons = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public PokemonController() {
        pokemons.addAll(List.of(
                new Pokemon(idCounter.getAndIncrement(), "Pikachu", "Elétrico"),
                new Pokemon(idCounter.getAndIncrement(), "Charmander", "Fogo"),
                new Pokemon(idCounter.getAndIncrement(), "Bulbasaur", "Planta/Veneno"),
                new Pokemon(idCounter.getAndIncrement(), "Squirtle", "Água")
        ));
    }

    @GetMapping
    public Iterable<Pokemon> getPokemons() {
        return pokemons;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable int id) {
        Optional<Pokemon> pokemon = pokemons.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
        return pokemon.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pokemon> postPokemon(@RequestBody Pokemon pokemon) {
        pokemon.setId(idCounter.getAndIncrement()); // Atribui um novo ID autoincrementado
        pokemons.add(pokemon);
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> putPokemon(@PathVariable int id,
                                              @RequestBody Pokemon pokemon) {
        // Procura o Pokémon pelo id
        Optional<Pokemon> existingPokemon = pokemons.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst();

        if (existingPokemon.isPresent()) {
            // Atualiza os dados do Pokémon existente
            Pokemon updatedPokemon = existingPokemon.get();
            updatedPokemon.setName(pokemon.getName());
            updatedPokemon.setType(pokemon.getType());
            // Atualize outros campos conforme necessário

            return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
        } else {
            // Pokémon não encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable int id) {
        boolean removed = pokemons.removeIf(p -> Objects.equals(p.getId(), id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

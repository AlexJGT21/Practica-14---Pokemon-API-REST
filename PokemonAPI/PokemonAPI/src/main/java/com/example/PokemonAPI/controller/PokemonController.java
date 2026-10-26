package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.repository.PokemonRepository;
import com.example.PokemonAPI.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    //BUSCA TODOS LOS POKEMONES
    @GetMapping
    public List<Pokemon> listarTodos() {
        return pokemonService.listarTodos();
    }

    //OBTENER UN POKEMON POR ID
    @GetMapping("/{id}")
    public Pokemon listarPorId(@PathVariable Long id) {
        return pokemonService.buscarPorId(id).orElse(null);
    }

    //GUARDA UN POKEMON
    @PostMapping
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.guardar(pokemon);
    }

    //ACTUALIZA COMPLETAMENTE UN POKEMON
    @PutMapping("/{id}")
    public Pokemon actualizarPokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemon(id, pokemon).orElse(null);
    }

    //ACTUALIZA PARCIALMENTE UN POKEMON
    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarParcial(id, pokemon).orElse(null);
    }

    //ELIMINA TOTALMENTE UN POKEMON
    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id) {
        pokemonService.eliminarPokemon(id);
    }

}


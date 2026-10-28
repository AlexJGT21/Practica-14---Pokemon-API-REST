package com.example.PokemonAPI.service;

import com.example.PokemonAPI.exception.BusinessRuleException;
import com.example.PokemonAPI.exception.ResourceNotFoundException;
import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    //LISTA TODOS LOS POKEMONES DE LA BASE DE DATOS
    public List<Pokemon> listarTodos() {
        return pokemonRepository.findAll();
    }

    //GUARDA UN POKEMON
    public Pokemon guardar(Pokemon pokemon) {
        if (pokemonRepository.existByNombreIgnoreCase(pokemon.getNombre())) {
            throw new BusinessRuleException("Pokemon Ya existe en el sistema");
        }
        return pokemonRepository.save(pokemon);
    }

    //BUSCA UN POKEMONS POR ID
    public Pokemon buscarPorId(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el pokemon con ID: " + id));
    }

    //ACTUALIZA COMPLETAMENTE UN POKEMON
    public Optional<Pokemon> actualizarPokemon(Long id, Pokemon pokemon) {
        return pokemonRepository.findById(id).map(pokemonExistente -> {
            pokemonExistente.setNombre(pokemon.getNombre());
            pokemonExistente.setTipo(pokemon.getTipo());
            pokemonExistente.setNivel(pokemon.getNivel());
            pokemonExistente.setAtaque(pokemon.getAtaque());
            pokemonExistente.setDefensa(pokemon.getDefensa());
            pokemonExistente.setDescripcion(pokemon.getDescripcion());
            pokemonExistente.setImagenUrl(pokemon.getImagenUrl());
            return pokemonRepository.save(pokemonExistente);
        });
    }

    //ACTUALIZA PARCIALMENTE UN POKEMON
    public Optional<Pokemon> actualizarParcial(Long id, Pokemon pokemon) {
        return pokemonRepository.findById(id).map(pokemonExistente -> {
            if (pokemon.getNombre() != null) pokemonExistente.setNombre(pokemon.getNombre());
            if (pokemon.getTipo() != null) pokemonExistente.setTipo(pokemon.getTipo());
            if (pokemon.getNivel() != null) pokemonExistente.setNivel(pokemon.getNivel());
            if (pokemon.getAtaque() != null) pokemonExistente.setAtaque(pokemon.getAtaque());
            if (pokemon.getDefensa() != null) pokemonExistente.setDefensa(pokemon.getDefensa());
            if (pokemon.getDescripcion() != null) pokemonExistente.setDescripcion(pokemon.getDescripcion());
            if (pokemon.getImagenUrl() != null) pokemonExistente.setImagenUrl(pokemon.getImagenUrl());
            return pokemonRepository.save(pokemonExistente);
        });
    }

    //ELIMINA TOTALMENTE UN POKEMON
    public Boolean eliminarPokemon(Long id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

package com.project.mongodb.springboot_mdb.service;

import com.project.mongodb.springboot_mdb.dto.PokemonRequest;
import com.project.mongodb.springboot_mdb.dto.PokemonResponse;
import com.project.mongodb.springboot_mdb.model.Pokemon;
import com.project.mongodb.springboot_mdb.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PokemonService {

    @Autowired
    private final PokemonRepository pokemonRepository;
    public void registerPokemon(PokemonRequest pokemonRequest){
        Pokemon pokemon = Pokemon.builder()
                .pokeDexNumber(pokemonRequest.getPokeDexNumber())
                .pokemonName(pokemonRequest.getPokemonName())
                .type1(pokemonRequest.getType1())
                .build();
        pokemonRepository.save(pokemon);
        log.info("Pokemon {} is saved", pokemon.getId());

    }
    public void registerMultiplePokemon(List<Pokemon> pokemon){
        pokemonRepository.saveAll(pokemon);

    }

    public List<PokemonResponse> getAllPokemon(){
        List<Pokemon> pokemon = pokemonRepository.findAll();
        return pokemon.stream().map(this::pokemonResponse).collect(Collectors.toList());
    }


    private PokemonResponse pokemonResponse(Pokemon pokemon){
        return PokemonResponse.builder()
                .id(pokemon.getId())
                .pokeDexNumber(pokemon.getPokeDexNumber())
                .pokemonName(pokemon.getPokemonName())
                .type1(pokemon.getType1())
                .build();
    }

    public Pokemon findOnePokemon(String id){
         Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
       return pokemonOptional.orElse(null);

    }

    public void updatePokemon(Pokemon pokemonRequest){

        Pokemon pokemon1 = Pokemon.builder()
                .pokeDexNumber(pokemonRequest.getPokeDexNumber())
                .pokemonName(pokemonRequest.getPokemonName())
                .type1(pokemonRequest.getType1())
                .build();

        if (pokemon1!=null){
            pokemon1.setType1(pokemon1.getType1());
            pokemonRepository.save(pokemon1);
        }
        log.info("Pokemon {} is updated", pokemon1.getPokemonName());

    }


}

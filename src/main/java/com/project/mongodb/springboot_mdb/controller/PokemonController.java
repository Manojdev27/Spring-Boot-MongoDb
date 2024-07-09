package com.project.mongodb.springboot_mdb.controller;

import com.project.mongodb.springboot_mdb.dto.PokemonRequest;
import com.project.mongodb.springboot_mdb.dto.PokemonResponse;
import com.project.mongodb.springboot_mdb.model.Pokemon;
import com.project.mongodb.springboot_mdb.repository.PokemonRepository;
import com.project.mongodb.springboot_mdb.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

//    @Autowired
//    private final PokemonRepository pokemonRepository;

@PostMapping("/addPokemon")
@ResponseStatus(HttpStatus.CREATED)
public void savePokemon(@RequestBody PokemonRequest pokemonRequest){
    pokemonService.registerPokemon(pokemonRequest);
}

@GetMapping("/findAllPokemon")
@ResponseStatus(HttpStatus.OK)
public List<PokemonResponse> getAllPokemon(){
   return pokemonService.getAllPokemon();
}

@GetMapping("/findOnePokemon/{id}")
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<Pokemon> getSinglePokemon(@PathVariable("id") String id){
    Optional<Pokemon> pokemon = Optional.ofNullable(pokemonService.findOnePokemon(id));
    return pokemon.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

    @PostMapping("/addMultiplePokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMultiplePokemon(@RequestBody List<Pokemon> pokemon){
pokemonService.registerMultiplePokemon(pokemon);
    }

@PutMapping("/updatePokemon")
@ResponseStatus(HttpStatus.CREATED)
public void updatePokemon(@RequestBody Pokemon pokemon){
pokemonService.updatePokemon(pokemon);
}
}

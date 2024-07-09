package com.project.mongodb.springboot_mdb.repository;

import com.project.mongodb.springboot_mdb.dto.PokemonRequest;
import com.project.mongodb.springboot_mdb.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {


}

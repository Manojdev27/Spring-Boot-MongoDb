package com.project.mongodb.springboot_mdb.dto;

import com.project.mongodb.springboot_mdb.model.Type1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequest {

    private int pokeDexNumber;

    private String pokemonName;

    private Type1 type1;

}

package com.project.mongodb.springboot_mdb.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document(collection = "Pokemon")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Pokemon {

    @Id
    private String id;

    private int pokeDexNumber;

    private String pokemonName;

    @DocumentReference(collection = "Type1")
    private Type1 type1;
}

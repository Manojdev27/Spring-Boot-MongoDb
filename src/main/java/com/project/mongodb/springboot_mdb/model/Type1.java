package com.project.mongodb.springboot_mdb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "Type1")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Type1 {

    @Id
    private String id;

    private int type1Id;

    private String typeName;

    @DocumentReference(collection = "Pokemon")
    private List<Pokemon> pokemon;

}

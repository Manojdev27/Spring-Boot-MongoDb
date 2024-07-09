package com.project.mongodb.springboot_mdb.controller;

import com.project.mongodb.springboot_mdb.model.Pokemon;
import com.project.mongodb.springboot_mdb.model.Type1;
import com.project.mongodb.springboot_mdb.repository.Type1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type1")
@RequiredArgsConstructor
public class Type1Controller {

    @Autowired
    private final Type1Repository type1Repository;

    @PostMapping("/addTypes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMultipleTypes(@RequestBody List<Type1> type1) {
        type1Repository.saveAll(type1);
    }

    @GetMapping("/findOneType/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Type1> getSingleTypes(@PathVariable("id") String id){
       Optional<Type1> type1 =  type1Repository.findById(id);
        return type1.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllTypes")
    @ResponseStatus(HttpStatus.OK)
    public List<Type1> getAllTypes(){
        return type1Repository.findAll();
    }

    @PutMapping("/updateType")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateType1(@RequestBody Type1 type1){
        Type1 type11 = Type1.builder()
                .id(type1.getId())
                .type1Id(type1.getType1Id())
                .typeName(type1.getTypeName())
                .pokemon(type1.getPokemon())
                .build();

        if(type11!=null){
            type11.setPokemon(type11.getPokemon());
            type1Repository.save(type11);
        }


    }
}


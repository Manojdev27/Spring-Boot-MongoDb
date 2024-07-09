package com.project.mongodb.springboot_mdb.repository;


import com.project.mongodb.springboot_mdb.model.Type1;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Type1Repository extends MongoRepository<Type1, String> {



}

package com.project.mongodb.springboot_mdb;

import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringBootMdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMdbApplication.class, args);
	}

}

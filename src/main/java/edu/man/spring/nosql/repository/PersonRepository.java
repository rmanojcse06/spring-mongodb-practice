package edu.man.spring.nosql.repository;

import edu.man.spring.nosql.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
* This repository interface is defined in MongoConfig.java
* */
public interface PersonRepository extends MongoRepository<Person, String> { }

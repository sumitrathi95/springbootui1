package com.restapi.repository;

import java.util.List;

import com.restapi.model.Patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MyRepository extends MongoRepository<Patient, String> {

    //List<Patient> getByName(String name);
    
    @Query(value = "{$or:[{firstname:{$regex:?0,$options:'i'}},{lastname:{$regex:?0,$options:'i'}}]}")
    List<Patient> getByFnameAndLname(String name);

    
}
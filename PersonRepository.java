package com.example.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByID(int id);

}
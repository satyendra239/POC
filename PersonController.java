package com.example.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.Person;
import com.example.model.Address;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;

import java.util.*;
@RestController
public class PersonController {
	@Autowired
	PersonRepository repository;
	@Autowired
	PersonService personService;
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	   public ResponseEntity<Object> addPerson(@RequestBody Person person) {
	      //productRepo.put(product.getId(), product);
		Person p =personService.addPerson();
		if(p!= null)
		{
			return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Product is not created successfully", HttpStatus.BAD_REQUEST);
		}
	     // return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   } 
	
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
	   public ResponseEntity<Object> update(@PathVariable("id") int id ) {
	      //productRepo.put(product.getId(), product);
		//Person p = new Person();
		
		List<Person> person = repository.findByID(id);
		repository.delete(person.get(0));
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   } 
}

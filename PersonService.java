package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Address;
import com.example.model.Person;
import com.example.repository.PersonRepository;

@Component
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	
	
	public Person addPerson() {
		Person p = new Person();
		p.setId(1);
		p.setFirstName("rohan");
		p.setLastName("shukla");
		Address address = new Address();
		address.setId(1);
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setPostalCode("500081");
		address.setStreet("xxxxyyy");
		
		List<Address> laddress = new ArrayList<>();
		laddress.add(address);
		p.setAddress(laddress);
		 return p = repository.save(p);
	}

}

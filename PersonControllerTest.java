package com.example.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.Assert.assertEquals;

import java.util.*;
import com.example.model.Address;
//importcom.example.StudentService;
import com.example.model.Person;
import com.example.service.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class)
@WithMockUser
public class PersonControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;
	
	Address address= new Address(1,"Hyderabad","Telangana","500081","xxxxy");
	//address.setId(1)
	List<Address> lstAddress = new ArrayList<>();
	lstAddress.add(address);
	Person mockPerson = new Person(1,"rohan","shukla",lstAddress);
	
			
			@Test
			 public ResponseEntity<Object> addPerson(){
				Mockito.when(
					personService.addPerson()).thenReturn(mockPerson);

				//Send course as body to /students/Student1/courses
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
						"/person")
						.accept(MediaType.APPLICATION_JSON).content(mockPerson)
						.contentType(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				MockHttpServletResponse response = result.getResponse();

				assertEquals(HttpStatus.CREATED.value(), response.getStatus());
			 }

	

}

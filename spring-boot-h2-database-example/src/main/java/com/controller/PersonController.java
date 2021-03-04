package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;
import com.service.PersonService;
//creating RestController
@RestController
public class PersonController 
{
//autowired the StudentService class
@Autowired
PersonService personService;
//creating a get mapping that retrieves all the students detail from the database 
@GetMapping("/student")
private List<Person> getAllPerson() 
{
return personService.getAllPerson();
}
//creating a get mapping that retrieves the detail of a specific student
@GetMapping("/student/{id}")
private Person getStudent(@PathVariable("id") int id) 
{
return personService.getPersonById(id);
}
//creating a delete mapping that deletes a specific student
@DeleteMapping("/student/{id}")
private void deleteStudent(@PathVariable("id") int id) 
{
personService.delete(id);
}
//creating post mapping that post the student detail in the database
@PostMapping("/student")
private int saveStudent(@RequestBody Person person) 
{
	personService.saveOrUpdate(person);
return person.getId();
}
}

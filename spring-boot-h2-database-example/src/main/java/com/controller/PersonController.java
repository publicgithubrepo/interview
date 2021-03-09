package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.PersonNotFoundException;
import com.model.Person;
import com.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;

	
	@GetMapping("/person")
	public List<Person> getAllPerson() {
		return personService.getAllPerson();
	}

	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		Person person = null;
		person = personService.getPersonById(id);
		if (null != person) {
			return person;
		} else {
			throw new PersonNotFoundException();
		}
	}

	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		personService.delete(id);
	}

	@PostMapping("/person")
	public int savePerson(@RequestBody Person person) {
		personService.saveOrUpdate(person);
		return person.getId();
	}

	@GetMapping("/person/count")
	public long getPersonCount() {
		return personService.personCount();
	}
}

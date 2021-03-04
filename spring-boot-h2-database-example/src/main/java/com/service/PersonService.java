package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Person;
import com.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		return persons;
	}

	// getting a specific record
	public Person getPersonById(int id) {
		return personRepository.findById(id).get();
	}

	public void saveOrUpdate(Person person) {
		personRepository.save(person);
	}

	// deleting a specific record
	public void delete(int id) {
		personRepository.deleteById(id);
	}
}
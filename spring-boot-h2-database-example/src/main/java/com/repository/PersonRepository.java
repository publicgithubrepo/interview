package com.repository;
import org.springframework.data.repository.CrudRepository;

import com.model.Person;
public interface PersonRepository extends CrudRepository<Person, Integer>
{
}

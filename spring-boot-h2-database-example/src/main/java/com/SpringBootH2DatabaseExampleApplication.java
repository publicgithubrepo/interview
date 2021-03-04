package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.model.Person;
import com.repository.PersonRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class SpringBootH2DatabaseExampleApplication implements CommandLineRunner
{
	@Autowired
    private ApplicationContext applicationContext;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
		
	}
	
	@Override
    public void run(String... args) throws Exception {

      //  System.out.println(applicationContext.getDisplayName());
      //  System.out.println(applicationContext.getId());

        PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);
        //add
        Person person=new Person();
        person.setId(Integer.parseInt(args[0]));
        person.setFirstName(args[1]);
        person.setSurname(args[2]);
		personRepository.save(person);
		
		//list
		personRepository.findAll().forEach(pe->System.out.println(pe.getId()+"  "+pe.getFirstName()+ " "+pe.getSurname()));
		
		//count
		System.out.println(personRepository.count());
        
        //update
        person.setFirstName(args[3]);
        person.setSurname(args[4]);
        personRepository.save(person);
        
      //list
      	personRepository.findAll().forEach(pe->System.out.println(pe.getId()+"  "+pe.getFirstName()+ " "+pe.getSurname()));
        
        //delete
        
      	personRepository.deleteAll();
      	
      	//count
      	
        System.out.println(personRepository.count());
        
    }

}

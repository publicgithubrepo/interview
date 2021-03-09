import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.controller.PersonController;
import com.model.Person;
import com.service.PersonService;
import com.sun.xml.bind.v2.schemagen.xmlschema.Any;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.List;


import junit.framework.Assert;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = ConfigurationCls.class)
public class PersonControllerTest {

	public PersonControllerTest() {

	}

	@Autowired
	PersonController personController;

	@MockBean
	PersonService personService;

	@Test
	public void testSavePerson() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("fname");
		person.setSurname("sname");
		personController.savePerson(person);
		Assert.assertEquals(1, person.getId());
	}

	@Test
	public void testGetAllPerson() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("fname");
		person.setSurname("sname");
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		when(personService.getAllPerson()).thenReturn(persons);
		List<Person> personslist = personController.getAllPerson();
		Assert.assertEquals(1, personslist.size());

	}

	@Test
	public void testGetPerson() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("fname");
		person.setSurname("sname");
		
		when(personService.getPersonById(any(int.class))).thenReturn(person);
		Person res=personController.getPerson(1);
		Assert.assertEquals(1, res.getId());

	}

	@Test
	public void testDeletePerson() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("fname");
		person.setSurname("sname");
		personController.deletePerson(person.getId());

	}

	@Test
	public void testGetPersonCount() {

		Person person = new Person();
		person.setId(1);
		person.setFirstName("fname");
		person.setSurname("sname");
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		when(personService.getAllPerson()).thenReturn(persons);
		List<Person> personslist = personController.getAllPerson();
		Assert.assertEquals(1, personslist.size());

	}

}

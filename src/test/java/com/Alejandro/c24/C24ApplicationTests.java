package com.Alejandro.c24;
import com.Alejandro.c24.entity.Person;
import com.Alejandro.c24.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonServiceImpl personService;

	@Test
	public void testGetAllPersons() {
		Person person1 = new Person();
		person1.setName("John");

		Person person2 = new Person();
		person2.setName("Jane");

		when(personRepository.findAll()).thenReturn(Arrays.asList(person1, person2));

		List<Person> persons = personService.getAllPersons();
		assertEquals(2, persons.size());
		assertEquals("John", persons.get(0).getName());
		assertEquals("Jane", persons.get(1).getName());
	}

	@Test
	public void testCreatePerson() {
		Person person = new Person();
		person.setName("John");

		when(personRepository.save(person)).thenReturn(person);

		Person createdPerson = personService.createPerson(person);
		assertEquals("John", createdPerson.getName());
	}
}
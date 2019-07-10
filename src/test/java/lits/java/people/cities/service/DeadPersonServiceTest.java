package lits.java.people.cities.service;


import lits.java.people.cities.PeopleRepository;
import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.impl.DeadPeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeadPersonServiceTest {

    @Mock
    private PeopleRepository peopleRepositoryMock;

    @Mock
    private ModelMapper mapperMock;

    @InjectMocks
    PeopleService peopleService = new DeadPeopleService();

    @Test
    public void shouldReturnPersonListWhenAskedForAllPeople() {
        Person person = new Person();

        Person deadPerson = person;

        deadPerson.setAlive(false);

        when(peopleRepositoryMock.findAll(Example.of(deadPerson))).thenReturn(Arrays.asList(deadPerson));

        peopleService.getAllPeople();

        verify(peopleRepositoryMock).findAll(Example.of(deadPerson));
    }

    @Test
    public void shouldSavePerson() {
        PersonDTO personToSave = new PersonDTO();
        when(mapperMock.map(personToSave, Person.class)).thenReturn(new Person());

        when(peopleService.save(personToSave)).thenReturn(new PersonDTO());

        assertNotNull(peopleService.save(personToSave));
    }

    @Test
    public void shouldGetByIdThePersonWithSpecifiedId() {
        Person person = new Person();
        person.setId(1);

        Person deadPerson = person;

        deadPerson.setAlive(false);

        when(peopleRepositoryMock.findOne(Example.of(deadPerson))).thenReturn(Optional.of(deadPerson));

        peopleService.getById(1);

        verify(peopleRepositoryMock).findOne(Example.of(deadPerson));
    }

    @Test
    public void shouldGetByNameThePersonWithSpecifiedName() {
        Person person = new Person();

        Person deadPerson = person;

        deadPerson.setAlive(false);

        person.setFirstName("Test");

        when(mapperMock.map(person,PersonDTO.class)).thenReturn(new PersonDTO());
        when(peopleRepositoryMock.findAll(Example.of(deadPerson))).thenReturn(Arrays.asList(deadPerson));
        when(peopleService.getByName(anyString())).thenReturn(Arrays.asList(new PersonDTO()));

        peopleService.getByName("Test");

        verify(peopleRepositoryMock).findAll(Example.of(deadPerson));
    }


}

package lits.java.people.cities.service;

import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;

import java.util.List;

public interface PeopleService {
    PersonDTO getById(Integer id);

    List<PersonDTO> getAllPeople();

    PersonDTO save(PersonDTO person);

    List<PersonDTO> getByName(String name);
}
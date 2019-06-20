package lits.java.people.cities.service;

import lits.java.people.cities.model.Person;

import java.util.List;

public interface PeopleService {
    Person getById(Integer id);

    List<Person> getAllPeople();

    Person save(Person person);
}
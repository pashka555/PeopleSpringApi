package lits.java.people.cities.repository;

import lits.java.people.cities.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<Person,Integer> {
    List<Person> findByFirstName(String name);
}

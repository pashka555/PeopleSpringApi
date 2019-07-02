package lits.java.people.cities.repository;

import lits.java.people.cities.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<Person,Integer> {
}

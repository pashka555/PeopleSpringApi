package lits.java.people.cities;

import lits.java.people.cities.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person,Integer> {
}

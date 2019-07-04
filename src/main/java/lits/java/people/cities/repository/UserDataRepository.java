package lits.java.people.cities.repository;

import lits.java.people.cities.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<User, Integer> {

    User findOneByUsername (String username);
}

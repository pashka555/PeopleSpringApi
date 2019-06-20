package lits.java.people.cities.service.impl;

import lits.java.people.cities.PeopleRepository;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="alive")
public class AlivePeopleService implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ModelMapper Mapper;

    @Override
    public Person getById(Integer id) {
        return peopleRepository.getOne(id);
    }

    @Override
    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return peopleRepository.save(person);
    }
}

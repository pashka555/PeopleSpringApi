package lits.java.people.cities.service.impl;

import lits.java.people.cities.PeopleRepository;
import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value="alive")
public class AlivePeopleService implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ModelMapper Mapper;

    @Override
    public PersonDTO getById(Integer id) {
        Person toGet = new Person();
        toGet.setId(id);
        toGet.setAlive(true);
        return Mapper.map(peopleRepository.findOne(Example.of(toGet)),PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPeople() {
        Person alivePerson = new Person();
        alivePerson.setAlive(true);
        return peopleRepository.findAll(Example.of(alivePerson)).stream().map( x-> Mapper.map(x,PersonDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PersonDTO save(PersonDTO person) {
        Person toSave = Mapper.map(person,Person.class);
        toSave.setAlive(true);
        return Mapper.map(peopleRepository.save(toSave),PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        Person person = new Person();
        person.setFirstName(name);
        person.setAlive(true);
        List<PersonDTO> people = peopleRepository.findAll(Example.of(person))
                .stream().map(x-> Mapper.map(x,PersonDTO.class)).collect(Collectors.toList());

        return people;
    }
}

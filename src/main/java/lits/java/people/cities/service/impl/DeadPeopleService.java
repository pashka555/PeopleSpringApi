package lits.java.people.cities.service.impl;

import lits.java.people.cities.PeopleRepository;
import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value="dead")
public class DeadPeopleService implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ModelMapper Mapper;

    @Override
    public PersonDTO getById(Integer id) {

        return Mapper.map(peopleRepository.getOne(id),PersonDTO.class);

    }

    @Override
    public List<PersonDTO> getAllPeople() {
        return peopleRepository.findAll().stream().map( x-> {
            return (PersonDTO)(Mapper.map(x,PersonDTO.class));
        }).collect(Collectors.toList());
    }

    @Override
    public PersonDTO save(PersonDTO person) {
        return Mapper.map(peopleRepository.save(Mapper.map(person,Person.class)),PersonDTO.class);
    }
}

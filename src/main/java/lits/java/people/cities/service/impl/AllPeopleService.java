package lits.java.people.cities.service.impl;

import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.repository.PeopleRepository;
import lits.java.people.cities.service.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service(value="all")
public class AllPeopleService implements lits.java.people.cities.service.PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ModelMapper Mapper;

    @Override
    public PersonDTO getById(Integer id) {
        Person gotten = peopleRepository.findById(id).orElseThrow(
                ()-> new PersonNotFoundException("User with id " + id + " not found!")
        );

        return Mapper.map(gotten,PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPeople() {

        List<PersonDTO> allPeople = StreamSupport.stream(peopleRepository.findAll().spliterator(),false)
                .map(x-> { return Mapper.map(x,PersonDTO.class);})
                .collect(Collectors.toList());

        if(allPeople.isEmpty()) {
            throw new PersonNotFoundException("No users found");
        }

        return allPeople;
    }

    @Override
    public PersonDTO save(PersonDTO person) {
        PersonDTO savedPerson = Mapper.map(peopleRepository.save(Mapper.map(person,Person.class)),PersonDTO.class);

        return savedPerson;
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        List<PersonDTO> gotten = peopleRepository.findByFirstName(name).stream().map(
                x-> Mapper.map(x,PersonDTO.class)
        ).collect(Collectors.toList());

        if(gotten.isEmpty()) {
            throw new PersonNotFoundException("No people with name " + name + " found");
        };


        return gotten;
    }
}

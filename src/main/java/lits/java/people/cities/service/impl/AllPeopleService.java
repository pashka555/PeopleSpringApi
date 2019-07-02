package lits.java.people.cities.service.impl;

import lits.java.people.cities.repository.PeopleRepository;
import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value="all")
public class AllPeopleService implements lits.java.people.cities.service.PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private ModelMapper Mapper;

    @Override
    public PersonDTO getById(Integer id) {


        if (!peopleRepository.existsById(id))
        {
            throw new PersonNotFoundException("User with id " + id + " not found");
        }


        Person gotten = peopleRepository.findById(id).get();

        return Mapper.map(gotten,PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPeople() {



        return null;
    }

    @Override
    public PersonDTO save(PersonDTO person) {
        return Mapper.map(peopleRepository.save(Mapper.map(person,Person.class)),PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        return null;
    }
}

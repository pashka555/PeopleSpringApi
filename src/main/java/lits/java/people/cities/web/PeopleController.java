package lits.java.people.cities.web;

import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class PeopleController {

    @Autowired
    @Qualifier(value = "alive")
    private PeopleService peopleService;

    @GetMapping
    public List<PersonDTO> getAllPhones() {
        return peopleService.getAllPeople();
    }

    @GetMapping(value="/people")
    public PersonDTO getPhoneById(@RequestParam Integer id) {
        return peopleService.getById(id);
    }

    @PostMapping
    public PersonDTO savePhone(@RequestBody PersonDTO person) {
        return peopleService.save(person);
    }

    //@GetMapping
    //public List<Phone> getAllPhones() {
    //    return phoneDetailsService.getAll();
    //}
}
package lits.java.people.cities.web;

import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.Person;
import lits.java.people.cities.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
public class PeopleController {


    @Autowired
    private Map<String, PeopleService> personServicesMap;

    private PeopleService qualifiedPersonService(Boolean isAlive){
        //PeopleService peopleService = isAlive == null ?
        //        personServicesMap.get("all") :
        //        isAlive ?
        //        personServicesMap.get("alive") : personServicesMap.get("dead");
        return personServicesMap.get("all");
    }

    @GetMapping
    public List<PersonDTO> getAllPeople(@RequestParam(name = "alive", required = false) boolean isAlive) {
        return qualifiedPersonService(isAlive).getAllPeople();
    }

    @GetMapping(value="/people")
    public PersonDTO getPersonById(@RequestParam(name = "alive", required = false) boolean isAlive, @RequestParam Integer id) {
        return qualifiedPersonService(isAlive).getById(id);
    }

    @PostMapping
    public PersonDTO savePerson(@RequestParam(name = "alive", required = false) boolean isAlive, @Validated @RequestBody PersonDTO person) {
        return qualifiedPersonService(isAlive).save(person);
    }

    @GetMapping(value="/findPerson")
    public List<PersonDTO> getPeopleByName(@RequestParam(name = "alive", required = false) boolean isAlive, @RequestParam(name = "name") String name) {
        return qualifiedPersonService(isAlive).getByName(name);
    }

}
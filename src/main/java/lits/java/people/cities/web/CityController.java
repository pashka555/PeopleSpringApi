package lits.java.people.cities.web;

import lits.java.people.cities.dtos.CityDTO;
import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("city")
public class CityController {

    @Autowired
    @Qualifier(value = "city")
    CityService cityService;

    @PostMapping
    public CityDTO saveCity(@RequestBody CityDTO cityToSave) {
        return cityService.saveCity(cityToSave);
    }

    @GetMapping
    public List<PersonDTO> getPeopleFromCityId(@RequestParam(value = "id") Integer id) {
        return cityService.findPeopleInCityById(id);
    }
}

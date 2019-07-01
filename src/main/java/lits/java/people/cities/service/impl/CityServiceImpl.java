package lits.java.people.cities.service.impl;

import lits.java.people.cities.CityRepository;
import lits.java.people.cities.dtos.CityDTO;
import lits.java.people.cities.dtos.PersonDTO;
import lits.java.people.cities.model.City;
import lits.java.people.cities.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "city")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CityDTO getById(Integer id) {
        return modelMapper.map(cityRepository.getOne(id),CityDTO.class);
    }

    @Override
    public List<PersonDTO> findPeopleInCity(CityDTO city) {
        City originCity = cityRepository.findOne(Example.of(modelMapper.map(city,City.class))).get();

        return originCity.getPeople().stream()
                .map(x -> modelMapper.map(x,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> findPeopleInCityById(Integer id) {
        City originCity = cityRepository.getOne(id);

        return originCity.getPeople().stream()
                .map(x -> modelMapper.map(x,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> findAlivePeopleInCity(CityDTO city) {
        City originCity = cityRepository.findOne(Example.of(modelMapper.map(city,City.class))).get();

        return originCity.getPeople().stream()
                .filter(x -> x.isAlive())
                .map(x -> modelMapper.map(x,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> findAlivePeopleInCityById(Integer id) {
        City originCity = cityRepository.getOne(id);

        return originCity.getPeople().stream()
                .filter(x -> x.isAlive())
                .map(x -> modelMapper.map(x,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> findDeadPeopleInCity(CityDTO city) {
        City originCity = cityRepository.findOne(Example.of(modelMapper.map(city,City.class))).get();

        return originCity.getPeople().stream()
                .filter(x -> !x.isAlive())
                .map(x -> modelMapper.map(x,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> findDeadPeopleInCityById(Integer id) {
        City originCity = cityRepository.getOne(id);

        return originCity.getPeople().stream()
                .filter(x -> !x.isAlive())
                .map(x -> modelMapper.map(x,PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CityDTO saveCity(CityDTO city) {
        return modelMapper.map(cityRepository.save(modelMapper.map(city,City.class)),CityDTO.class);
    }
}

package lits.java.people.cities.service;

import lits.java.people.cities.dtos.CityDTO;
import lits.java.people.cities.dtos.PersonDTO;

import java.util.List;

public interface CityService {
    public CityDTO getById(Integer id);

    public List<PersonDTO> findPeopleInCity(CityDTO city);

    public List<PersonDTO> findPeopleInCityById(Integer id);

    public List<PersonDTO> findAlivePeopleInCity(CityDTO city);

    public List<PersonDTO> findAlivePeopleInCityById(Integer id);

    public List<PersonDTO> findDeadPeopleInCity(CityDTO city);

    public List<PersonDTO> findDeadPeopleInCityById(Integer id);

    public CityDTO saveCity(CityDTO city);
}

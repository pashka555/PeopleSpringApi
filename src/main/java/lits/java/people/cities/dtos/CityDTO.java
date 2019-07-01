package lits.java.people.cities.dtos;

import lits.java.people.cities.model.Person;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CityDTO {

    private String location;

    private String postcode;

    //private Integer population;

    private Timestamp builtOn;

    private List<Person> people;

}
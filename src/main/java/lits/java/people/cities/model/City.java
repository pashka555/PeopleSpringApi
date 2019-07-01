package lits.java.people.cities.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@EqualsAndHashCode(exclude = "cityId")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name = "location")
    private String location;

    @Column(name = "postcode")
    private String postcode;

    //@Column(name = "population")
    //private Integer population;

    @Column(name = "built_on")
    private Timestamp builtOn;

    @OneToMany(mappedBy = "cityId")
    private List<Person> people;

}

package lits.java.people.cities.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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

    @Column(name = "population")
    private Integer population;

    @Column(name = "built_on")
    private Timestamp builtOn;

    @OneToMany(mappedBy = "cityId")
    private List<Person> people;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Timestamp getBuiltOn() {
        return builtOn;
    }

    public void setBuiltOn(Timestamp builtOn) {
        this.builtOn = builtOn;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}

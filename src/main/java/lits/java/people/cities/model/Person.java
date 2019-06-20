package lits.java.people.cities.model;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;

}

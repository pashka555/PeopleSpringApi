package lits.java.people.cities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phone;
}

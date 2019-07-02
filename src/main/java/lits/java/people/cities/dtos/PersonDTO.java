package lits.java.people.cities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {

    @NotNull
    private String firstName;

    private String lastName;

    private String middleName;

    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;

    private String phone;

}

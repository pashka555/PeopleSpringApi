package lits.java.people.cities.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthRequest {
    @NotEmpty
    @Size(max = 64)
    private String email;
    @NotEmpty
    @Size(max = 32)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

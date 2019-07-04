package lits.java.people.cities.service;

public interface TokenService {
    Long parseToken (String token);

    String createToken (Long id);
}

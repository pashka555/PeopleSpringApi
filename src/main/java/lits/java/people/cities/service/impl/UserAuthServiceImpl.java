package lits.java.people.cities.service.impl;

import lits.java.people.cities.model.User;
import lits.java.people.cities.repository.UserDataRepository;
import lits.java.people.cities.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public String auth(String username, String pass) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        pass
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userDataRepository.findOneByUsername(username);

        System.out.println("message from authServiceImpl");
        return tokenService.createToken(user.getId());
    }
}

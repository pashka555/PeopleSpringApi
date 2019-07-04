package lits.java.people.cities.web;

import io.swagger.annotations.ApiOperation;
import lits.java.people.cities.model.User;
import lits.java.people.cities.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserAuthController {

    private UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService){
        this.userAuthService = userAuthService;
    }


    @PostMapping(value = "/login")
    @ApiOperation("auth")
    public ResponseEntity<?> auth(@RequestBody User user){

        System.out.println("user.getUsername() from UserAuthController (the same as in POST command): "+user.getUsername()); // here works. userName = is the same as in POST request

        return ResponseEntity.ok(userAuthService.auth(user.getUsername(), user.getPassword()));
    }

//
//    @PostMapping
//    public User savePerson (@RequestBody User user){
//
//        return UserServiceImpl.save(user);
//    }
//}
//
//@RequestMapping (value = "/api/users")
//public class UserController {
//
//    @PostMapping
//    public ResponseEntity<?> signup(@RequestBody User user) {
//        return ResponseEntity.ok(userAuthService.auth(user.getUsername(), user.getPassword()));
//    }

//    @PostMapping
//    public User saveUser(@RequestBody User user) {
//        UserServiceImpl.save(user);
//        return user;
//    }
//}
}
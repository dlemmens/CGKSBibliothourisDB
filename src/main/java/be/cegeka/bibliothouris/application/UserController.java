package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Transactional
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void addUser(
            @RequestParam(value = "inss", required = true) String inss,
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "street", required = false) String street,
            @RequestParam(value = "houseNumber", required = false) String houseNumber,
            @RequestParam(value = "postalCode", required = false) String postalCode,
            @RequestParam(value = "city", required = true) String city) {
        userService.addUser(inss, lastName, firstName, password, street, houseNumber, postalCode, city);
    }

}

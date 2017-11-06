package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    public void addUser(String inss, String lastName, String firstName, String street, String houseNumber, String postalCode, String city){
        userRepository.addUser(new User(inss, lastName, firstName, street, houseNumber, postalCode, city));
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}

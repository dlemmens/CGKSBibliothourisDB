package be.cegeka.bibliothouris.domain.users;

import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

public class UserTestBuilder {

    private int id;
    private String inss;
    private String lastName;
    private String firstName;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;
    private List<UserRole> roles = new ArrayList<>();

    public static UserTestBuilder aUser(){
        return new UserTestBuilder()
                .withFirstName("Seppe")
                .withLastName("Gielen")
                .withCity("Hasselt")
                .withInss("1234");

    }

    public UserTestBuilder withRole(UserRole rol) {
        this.roles.add(rol);
        return this;
    }

    public User build(){
        User user = new User(inss, lastName, firstName, street, houseNumber, postalCode, city, roles);
        ReflectionTestUtils.setField(user,"id", id);
        return user;
    }

    public UserTestBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserTestBuilder withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public UserTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserTestBuilder withCity(String city) {
        this.city = city;
        return this;
    }
}

package be.cegeka.bibliothouris.domain.users;

import org.springframework.test.util.ReflectionTestUtils;

public class UserTestBuilder {

    private int id;
    private String inss;
    private String lastName;
    private String firstName;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;

    public static UserTestBuilder aUser(){
        return new UserTestBuilder()
                .withFirstName("Seppe")
                .withLastName("Gielen")
                .withCity("Hasselt")
                .withInss("1234");
    }

    public User build(){
        User user = new User(inss, lastName, firstName, street, houseNumber, postalCode, city);
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

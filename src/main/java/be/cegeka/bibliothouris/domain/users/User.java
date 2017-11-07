package be.cegeka.bibliothouris.domain.users;

import org.apache.catalina.Role;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "INSS")
    private String inss;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "USER_WITH_ROLE",
            joinColumns = {@JoinColumn(name = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "r_id")}
    )

    private List<UserRole> roles= new ArrayList<UserRole>();

    private User() {
    }

    public User(String inss, String lastName, String firstName, String password, String street, String houseNumber, String postalCode, String city, List<UserRole > userRoles) {
        this.inss = inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.roles.addAll(userRoles);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return firstName;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return firstName != null ? firstName.equals(user.firstName) : user.firstName == null;
    } //Checks only FIRST NAME. Needs to be expanded!!!

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    } //Checks only FIRST NAME. Needs to be expanded!!!

    public String getInss() {
        return inss;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }
}

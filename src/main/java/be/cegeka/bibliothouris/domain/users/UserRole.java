package be.cegeka.bibliothouris.domain.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class UserRole {

    @Id
    private int id;
    @Column(name = "role")
    private String role;

//    private list<Strings> userRoles=


    private UserRole() {
    }

    public UserRole(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

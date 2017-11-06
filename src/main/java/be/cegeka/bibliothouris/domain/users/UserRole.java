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

    public UserRole(String role) {
        this.role = role;
    }


}

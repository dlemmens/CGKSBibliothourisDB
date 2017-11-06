package be.cegeka.bibliothouris.domain.users;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class UserRoleRepository {

    @PersistenceContext
    private EntityManager entityManager;



    public List<UserRole> findUserRole(String userRole) {
        return entityManager.createQuery("Select r from UserRole r where r.role=:role", UserRole.class).setParameter("role", userRole).getResultList();
    }
}

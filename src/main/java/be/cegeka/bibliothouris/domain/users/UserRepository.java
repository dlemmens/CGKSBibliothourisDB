package be.cegeka.bibliothouris.domain.users;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("Select u from User u", User.class).getResultList();
    }

    public void addUser(User user){
        entityManager.persist(user);
    }

    public User getUserByFirstName(String firstName) {
        return entityManager.createQuery("select u from User u where u.firstName like :firstName", User.class)
                .setParameter("firstName", firstName)
                .getSingleResult();
    }

    public User getUserByInss(String username) {
        return entityManager.createQuery("select u from User u where u.inss like :inss", User.class)
            .setParameter("inss", username)
            .getSingleResult();
    }
}

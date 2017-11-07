package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static be.cegeka.bibliothouris.domain.users.UserTestBuilder.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class UserRepositoryTest {

    @Inject
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private User seppe, kiki;

    @Before
    public void setup(){
        UserRole fakeRole = new UserRole(10, "FAKE");

        seppe = aUser().withFirstName("Seppe").withPassword("koekjes").withLastName("Gielen").withCity("Leuven").withInss("1234").withRole(fakeRole).build();
        kiki = aUser().withFirstName("Kiki").withPassword("wild").withLastName("Willems").withCity("Leuven").withInss("5678").withRole(fakeRole).build();


        entityManager.persist(fakeRole);
        entityManager.persist(seppe);
        entityManager.persist(kiki);
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = userRepository.getAllUsers();
        assertThat(users).containsOnly(seppe, kiki);
    }

    @Test
    public void getUserByFirstName(){
        User actual = userRepository.getUserByFirstName("Seppe");

        assertThat(actual).isEqualTo(seppe);
    }

    @Test
    public void getUserByFirstName_NoUserFound(){
        assertThatThrownBy(()-> { userRepository.getUserByFirstName("Seppe2"); } ).isInstanceOf(NoResultException.class);
    }

    @Test
    public void getUserByFirstName_NoUniqueUserFound(){
        entityManager.persist(aUser().withFirstName("Seppe").withPassword("koekjes").withLastName("Gielen").withCity("Leuven").withInss("12366664").build());

        assertThatThrownBy(()-> { userRepository.getUserByFirstName("Seppe"); } ).isInstanceOf(NonUniqueResultException.class);
    }

    @Test
    public void checkAddUsers(){
        User tbow = aUser().withFirstName("tbow").withPassword("rosalina").withInss("333333").build();
        userRepository.addUser(tbow);
        List<User> users = userRepository.getAllUsers();
        assertThat(users).containsOnly(seppe, kiki, tbow);
    }

    @After
    public void teardown(){
        entityManager.clear();
    }

}
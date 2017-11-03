package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.Application;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static be.cegeka.bibliothouris.domain.users.BookTestBuilder.aBook;
import static org.junit.Assert.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class BookRepositoryTest {

    @Inject
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Book bible;

    @Before
    public void setUp() throws Exception {
        bible = aBook().withTitle("Den Bijbel")
                .withAuthorFirstName("Gerrus")
                .withAuthorLastName("Maximus")
                .withIsbn("666")
                .build();
        entityManager.persist(bible);
    }

    @Test
    public void getDetails_shouldReturnBookDetails() throws Exception {
        Book book = bookRepository.getBookdetails(bible.getId());
        Assertions.assertThat(book).isEqualTo(bible);
    }
}
package be.cegeka.bibliothouris.domain.books;

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

import java.util.Arrays;

import static be.cegeka.bibliothouris.domain.books.BookTestBuilder.aBook;
import static org.assertj.core.api.Assertions.*;

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
    private Book koran;

    @Before
    public void setUp() throws Exception {
        bible = aBook().withTitle("Den Bijbel")
                .withAuthorFirstName("Gerrus")
                .withAuthorLastName("Maximus")
                .withIsbn("666")
                .build();
        koran = aBook().withTitle("de Koran")
                .withIsbn("1111")
                .withAuthorFirstName("oude")
                .withAuthorFirstName("klet")
                .build();
        entityManager.persist(bible);
        entityManager.persist(koran);
    }

    @Test
    public void getDetails_shouldReturnBookDetails() throws Exception {
        Book book = bookRepository.getBookdetails(bible.getId());
        assertThat(book).isEqualTo(bible);
    }

    @Test
    public void getAllBooks_shouldReturnAllBooks() throws Exception {
        assertThat(bookRepository.getAllBooks()).isEqualTo(Arrays.asList(bible,koran));
    }
}
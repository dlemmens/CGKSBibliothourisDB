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

import java.util.ArrayList;
import java.util.List;

import static be.cegeka.bibliothouris.domain.books.BookTestBuilder.aBook;

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
        entityManager.persist(bible);

        koran = aBook().withTitle("De Koran")
                .withAuthorFirstName("Mo")
                .withAuthorLastName("Hammed")
                .withIsbn("14566")
                .build();
        entityManager.persist(koran);
    }

    @Test
    public void getDetails_shouldReturnBookDetails() throws Exception {
        Book book = bookRepository.getBookdetails(bible.getId());
        Assertions.assertThat(book).isEqualTo(bible);
    }

    @Test
    public void getDetailsByCompleteISBN_shouldReturnBookDetails() throws Exception {
        List<Book> books = bookRepository.getBookDetailsByISBN("666");


        Assertions.assertThat(books).contains(bible);
    }

    @Test
    public void getDetailsByPartialFrontISBN_shouldReturnBookDetails() throws Exception {
        List<Book> books = bookRepository.getBookDetailsByISBN("*66");
        Assertions.assertThat(books).contains(bible);
    }

    @Test
    public void getDetailsByPartialBackISBN_shouldReturnBookDetails() throws Exception {
        List<Book> books = bookRepository.getBookDetailsByISBN("66*");
        Assertions.assertThat(books).contains(bible);
    }

    @Test
    public void getDetailsByPartialInISBN_shouldReturnBookDetails() throws Exception {
        List<Book> books = bookRepository.getBookDetailsByISBN("6*6");


        Assertions.assertThat(books).contains(bible);
    }

    @Test
    public void getDetailsByPartialFrontInISBN_shouldReturnBookDetails() throws Exception {
        List<Book> books = bookRepository.getBookDetailsByISBN("*6");
        Assertions.assertThat(books).contains(bible, koran);
    }

    @Test
    public void getDetailsByPartialBackInISBN_shouldReturnBookDetails() throws Exception {
        List<Book> books = bookRepository.getBookDetailsByISBN("1*5*");
        Assertions.assertThat(books).contains(koran);
    }


}
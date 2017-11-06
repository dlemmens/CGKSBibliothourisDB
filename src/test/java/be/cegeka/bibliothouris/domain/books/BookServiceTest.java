package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;



public class BookServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void whenAllBooksGetsCalled_shouldActivateCorrespondingMethodInBookRepository() throws Exception {
        bookService.getAllBooks();
        verify(bookRepository).getAllBooks();
    }

    @Test
    public void getBookDetailsByISBN_shouldActivateCorrespondingMethodInBookRepositoryWithCorrectISBN() throws Exception {
        bookService.getBookDetailsByISBN("1245");
        verify(bookRepository).getBookDetailsByISBN("1245");


    }
}
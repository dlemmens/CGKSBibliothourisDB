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
    public void whenASingleBookGetsAsked_shouldActivateCorrespondingMethodWithCorrectParameterInBookRepository() throws Exception {
        bookService.getBookDetails(25);
        verify(bookRepository).getBookdetails(25);
    }

    @Test
    public void whenSingleGetsAdded_ShouldActivateCorrespondingMethodInBookRepository() throws Exception {
        Book book = new Book("123456789", "Guggenheim koopt een neger", "Brusselmans", "Herman");

        bookService.addBook("123456789", "Guggenheim koopt een neger", "Brusselmans", "Herman");
        verify(bookRepository).addBook(book);
    }

    @Test
    public void getBookDetailsByISBN_shouldActivateCorrespondingMethodInBookRepositoryWithCorrectISBN() throws Exception {
        bookService.getBookDetailsByISBN("1245");
        verify(bookRepository).getBookDetailsByISBN("1245");
    }

    @Test
    public void getBookDetailsByTitle_shouldActivateCorrespondingMethodInBookRepositoryWithCorrectTitle() throws Exception {
        bookService.getBookDetailsByTitle("Ex-Drummer");
        verify(bookRepository).getBookDetailsByTitle("Ex-Drummer");
    }

    @Test
    public void getBookDetailsByAuthor_shouldActivateCorrespondingMethodInBookRepositoryWithCorrectAuthor() throws Exception {
        bookService.getBookDetailsByAuthor("Gerrus");
        verify(bookRepository).getBookDetailsByAuthor("Gerrus");
    }
}
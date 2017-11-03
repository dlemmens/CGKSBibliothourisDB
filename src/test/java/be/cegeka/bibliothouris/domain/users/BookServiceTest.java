package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.application.BookController;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
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
}
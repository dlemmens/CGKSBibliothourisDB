package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;

public class BookControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;
    @Test
    public void whenAllBooksGetsAsked_shouldActivateCorrespondingMethodInBookService() throws Exception {
        bookController.getAllBooks();
        verify(bookService).getAllBooks();
    }

    @Test
    public void whenASingleBookGetsAsked_shouldActivateCorrespondingMethodWithCorrectParameterInBookService() throws Exception {
          bookController.getBookDetails(25);
          verify(bookService).getBookDetails(25);
    }

    @Test
    public void addBook_shouldActivateCorrespondingMethod() throws Exception {
        bookController.addBook("123","titla", "blah","bloeh");
        verify(bookService).addBook("123","titla", "blah","bloeh");
    }


}
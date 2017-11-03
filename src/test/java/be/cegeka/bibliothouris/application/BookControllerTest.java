package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

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
}
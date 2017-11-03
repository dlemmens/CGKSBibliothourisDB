package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.Book;
import be.cegeka.bibliothouris.domain.users.BookService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void whenGettingBookDetails_ShouldReturnDetailsOfASingleBook() throws Exception {
        
//        Book book1 = new Book("12345", "Jeroen's day out", "Jeroen", "Stroobants");
//        Book book2 = new Book("1358", "Jeroen's gows dancing", "Jeroen", "Stroobants");
//
//        when(bookService.getBookDetails("12345")).thenReturn(book1);
//        assertThat(bookController.getBookDetails("12345")).isEqualTo(book1);
    }
}
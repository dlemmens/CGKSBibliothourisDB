package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
@Transactional
public class BookController {

    @Inject
    private BookService bookService;

    @GetMapping(path = "/{id}")
    public Book getBookDetails(@PathVariable(value = "id") int id) {
        return bookService.getBookDetails(id);
    }
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

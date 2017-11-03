package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.Book;
import be.cegeka.bibliothouris.domain.users.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
@Transactional
public class BookController {
BookService bookService;

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

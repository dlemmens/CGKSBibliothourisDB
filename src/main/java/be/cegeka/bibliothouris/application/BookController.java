package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.Book;
import be.cegeka.bibliothouris.domain.users.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
}

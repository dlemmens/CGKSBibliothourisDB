package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(
            @RequestParam(value = "isbn", required = false) String isbn,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "authorLastName", required = false) String authorLastName,
            @RequestParam(value = "authorFirstName", required = false) String authorFirstName){
        bookService.addBook(isbn, title, authorLastName, authorFirstName);
    }



    @GetMapping(path = "/byISBN")
    public List<Book> getBookDetailsByISBN(@RequestParam(value = "ISBN")    String isbn) {
        return bookService.getBookDetailsByISBN(isbn);
    }
}

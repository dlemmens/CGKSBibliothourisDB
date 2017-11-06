package be.cegeka.bibliothouris.domain.books;

import org.springframework.data.annotation.Id;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Named
public class BookService {
    @Inject
    private BookRepository bookRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public BookService() {
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }


    public Book getBookDetails(int id) {

        return bookRepository.getBookdetails(id);
    }
}

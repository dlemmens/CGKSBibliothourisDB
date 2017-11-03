package be.cegeka.bibliothouris.domain.users;

import org.hibernate.Criteria;
import org.springframework.data.annotation.Id;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
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

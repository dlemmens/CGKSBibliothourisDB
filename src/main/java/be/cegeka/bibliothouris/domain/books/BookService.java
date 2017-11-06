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

    public BookService() {
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String isbn, String title, String authorLastName, String authorFirstName){
        bookRepository.addBook(new Book(isbn, title, authorLastName, authorFirstName));
    }



    public Book getBookDetails(int id) {
        return bookRepository.getBookdetails(id);
    }

    public List<Book> getBookDetailsByISBN(String isbn) {
        return bookRepository.getBookDetailsByISBN(isbn);
    }
}

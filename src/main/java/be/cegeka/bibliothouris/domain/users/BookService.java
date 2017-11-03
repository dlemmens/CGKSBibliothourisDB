package be.cegeka.bibliothouris.domain.users;

import java.util.List;

public class BookService {
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}

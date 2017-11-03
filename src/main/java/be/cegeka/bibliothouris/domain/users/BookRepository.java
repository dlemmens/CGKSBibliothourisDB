package be.cegeka.bibliothouris.domain.users;

import java.util.List;

public class BookRepository {
    List<Book> bookList;

    public List<Book> getAllBooks() {
        return bookList;
    }
}

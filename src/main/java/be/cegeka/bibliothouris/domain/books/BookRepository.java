package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class BookRepository {
    List<Book> bookList;

    @PersistenceContext
    private EntityManager entityManager;

//    Klopt nog niet ;)
    public List<Book> getAllBooks() {
        return bookList;
    }


    public Book getBookdetails(int id) {

        return entityManager.createQuery("select b from Book b where b.id=:id",Book.class).setParameter("id",id).getSingleResult();

    }

    public Book getBookDetailsByISBN(int isbn){
        return entityManager.createQuery("select b from Book b where b.isbn =: %isbn%",Book.class).setParameter("isbn", isbn).getSingleResult();
    }
}

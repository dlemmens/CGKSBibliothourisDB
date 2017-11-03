package be.cegeka.bibliothouris.domain.users;

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

        return entityManager.createQuery("select b from book b where id=:id",Book.class).setParameter("id",id).getSingleResult();

    }
}

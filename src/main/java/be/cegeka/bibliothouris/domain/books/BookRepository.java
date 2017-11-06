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

    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public Book getBookdetails(int id) {
        return entityManager.createQuery("select b from Book b where b.id=:id", Book.class).setParameter("id", id).getSingleResult();
    }

    public List<Book> getBookDetailsByISBN(String isbn) {
        return entityManager
                .createQuery("select b from Book b where b.isbn like :isbn", Book.class)
                .setParameter("isbn", isbn.replaceAll("\\*", "%"))
                .getResultList();
    }

}

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
        return entityManager.createQuery("select b from Book b", Book.class)
                .getResultList();
    }

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public Book getBookdetails(int id) {
        return entityManager.createQuery("select b from Book b where b.id=:id", Book.class)
                .setParameter("id", id).getSingleResult();
    }

    public List<Book> getBookDetailsByISBN(String isbn) {
        return entityManager
                .createQuery("select b from Book b where b.isbn like :isbn", Book.class)
                .setParameter("isbn", isbn.replaceAll("\\*", "%"))
                .getResultList();
    }

    public List<Book> getBookDetailsByTitle(String title) {
        return entityManager
                .createQuery("select b from Book b where b.title like :title", Book.class)
                .setParameter("title", title.replaceAll("\\*", "%"))
                .getResultList();
    }

    public List<Book> getBookDetailsByAuthor(String author) {
        return entityManager
                .createQuery("select b from Book b where b.authorFirstName like :author or " +
                        "b.authorLastName like :author or concat(b.authorFirstName,b.authorLastName) like :author or " +
                        "concat(b.authorFirstName,' ',b.authorLastName) like :author or " +
                        "concat(b.authorLastName,' ',b.authorFirstName) like :author or " +
                        "concat(b.authorLastName,b.authorFirstName) like :author", Book.class)
                .setParameter("author", author.replaceAll("\\*", "%"))
                .getResultList();
    }
}

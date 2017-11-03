package be.cegeka.bibliothouris.domain.users;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Book getBookdetails(int id) {

       return entityManager.createQuery("select b from book b where id=:id",Book.class).setParameter("id",id).getSingleResult();

    }
}

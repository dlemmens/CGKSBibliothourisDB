package be.cegeka.bibliothouris.domain.users;

import org.hibernate.Criteria;
import org.springframework.data.annotation.Id;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "id")

public class BookService {
    @Inject
    private BookRepository bookRepository;

    private int id;

    public BookService() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    public Book getBookDetails(int id) {

        //ga in de databank kijken naar de locatie ID nummer
        //en return die

//        Criteria crit = session.createCriteria(Book.class);
//        crit.add()
        //  SELECT  id
        //  FROM    books
        //  WHERE   id = idnummer
        return bookRepository.getBookdetails();
    }
}


/*Criteria crit = session.createCriteria(Product.class);
crit.add(Restrictions.eq("description","Mouse"));
List<Product> results = crit.list()
*/
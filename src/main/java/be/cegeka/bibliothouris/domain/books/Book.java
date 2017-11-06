package be.cegeka.bibliothouris.domain.books;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "LAST_NAME")
    private String authorLastName;
    @Column(name = "FIRST_NAME")
    private String authorFirstName;

    private Book(){
    }

    public Book(String isbn, String title, String authorLastName, String authorFirstName) {
        this.isbn = isbn;
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
    }

    public int getId() {
        return id;
    }
}

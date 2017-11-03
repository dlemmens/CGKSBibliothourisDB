package be.cegeka.bibliothouris.domain.users;

public class Book {
    private String isbn;
    private String title;
    private String authorLastName;
    private String authorFirstName;

    public Book(String isbn, String title, String authorLastName, String authorFirstName) {
        this.isbn = isbn;
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
    }

}

package be.cegeka.bibliothouris.domain.users;

import org.springframework.test.util.ReflectionTestUtils;

public class BookTestBuilder {

    private int id;
    private String isbn;
    private String title;
    private String authorLastName;
    private String authorFirstName;


    public static BookTestBuilder aBook() {
        return new BookTestBuilder()
                .withTitle("Boekske")
                .withIsbn("123")
                .withAuthorLastName("Vdh")
                .withAuthorFirstName("Gerri");
    }

    public BookTestBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookTestBuilder withAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public BookTestBuilder withAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public BookTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public Book build(){
        Book book = new Book(isbn, title, authorLastName, authorFirstName);
        ReflectionTestUtils.setField(book, "id", id);
        return book;
    }


}

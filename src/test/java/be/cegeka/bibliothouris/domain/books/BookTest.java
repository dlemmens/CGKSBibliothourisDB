package be.cegeka.bibliothouris.domain.books;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman");
    }

    @Test
    public void equals_SameBook_isTrue() throws Exception {
        Assertions.assertThat(book).isEqualTo(book);
    }

    @Test
    public void equals_BookWithSameTitleAuthorAndISBN_isTrue() throws Exception {
        assertThat(book).isEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(null);
    }

    @Test
    public void equals_ifOtherClass_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Object());
    }

    @Test
    public void equals_BookWithOtherTitle_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456", "Ex-Drummer2", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_BookWithOtherAuthorFirstName_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman2"));
    }

    @Test
    public void equals_BookWithOtherAuthorLastName_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans2", "Herman"));
    }

    @Test
    public void equals_BookWithOtherISBN_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456789", "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithNullTitle_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456", null, "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithNullAuthorLastName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456", "Ex-Drummer", null, "Herman"));
    }

    @Test
    public void equals_ObjectWithNullAuthorFirsttName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", null));
    }

    @Test
    public void equals_ObjectWithNullISBN_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book(null, "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithBothNullTitle_IsTrue() throws Exception {
        assertThat(new Book("123456", null, "Brusselsmans", "Herman"))
                .isEqualTo(new Book("123456", null, "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithBothNullAuthorLastName_IsTrue() throws Exception {
        assertThat(new Book("123456", "Ex-Drummer", null, "Herman")).
                isEqualTo(new Book("123456", "Ex-Drummer", null, "Herman"));
    }

    @Test
    public void equals_ObjectWithBothNullAuthorFirstName_IsTrue() throws Exception {
        assertThat(new Book("123456", "Ex-Drummer", "Brusselsmans", null)).
                isEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", null));
    }

    @Test
    public void equals_ObjectWithBothNullISBN_IsTrue() throws Exception {
        assertThat(new Book(null, "Ex-Drummer", "Brusselsmans", "Herman")).
                isEqualTo(new Book(null, "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithNoNullTitle_IsFalse() throws Exception {
        assertThat(new Book(null, "Ex-Drummer", "Brusselsmans", "Herman")).
                isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithNoNullAuthorLastName_IsFalse() throws Exception {
        assertThat(new Book("123456", null, "Brusselsmans", "Herman")).
                isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithNoNullAuthorFirstName_IsFalse() throws Exception {
        assertThat(new Book("123456", "Ex-Drummer", null, "Herman")).
                isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void equals_ObjectWithNoNullISBN_IsFalse() throws Exception {
        assertThat(new Book("123456", "Ex-Drummer", "Brusselsmans", null)).
                isNotEqualTo(new Book("123456", "Ex-Drummer", "Brusselsmans", "Herman"));
    }

    @Test
    public void getIdShouldReturnId() throws Exception {
        Assertions.assertThat(book.getId()).isEqualTo(0);
    }

    @Test
    public void getIsbnShouldReturnISBN() throws Exception {
        Assertions.assertThat(book.getIsbn()).isEqualTo("123456");
    }

    @Test
    public void getTitleShouldReturnTitle() throws Exception {
        Assertions.assertThat(book.getTitle()).isEqualTo("Ex-Drummer");
    }

    @Test
    public void getAuthorLastNameShouldReturnLastName() throws Exception {
        Assertions.assertThat(book.getAuthorLastName()).isEqualTo("Brusselsmans");
    }

    @Test
    public void getAuthorFirstNameShouldReturnFirstName() throws Exception {
        Assertions.assertThat(book.getAuthorFirstName()).isEqualTo("Herman");
    }
}
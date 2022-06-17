package io.company.library;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;


@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity(name="Book")
@Table(name="BOOK_TABLE")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BOOK_ID")
    private long bookId;
    @Column(name="BOOK_TITLE")
    private String title;
    private String author;
    private int pages;
    @Column(name="PUBLISHED_YEAR")
    private int publishedYear;
    @Column(name="ISBN")
    private String isbn;

    public Book(String title, String author, int pages, int publishedYear, String isbn) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
    }
}
package io.company.library;

//https://projectlombok.org/features/all
import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Book {


    private long bookId;

    private String title;

    private String author;
    private int pages;

    private int publishedYear;

    private String isbn;

    //constructor without ID
    public Book(String title, int pages, int publishedYear, String isbn) {
        this.title = title;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", authorName=" + author +
                ", pages=" + pages +
                ", publishedYear=" + publishedYear +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
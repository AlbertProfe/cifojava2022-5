package io.company.library;

//https://projectlombok.org/features/all
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Document("books")
public class Book {

	@Id
    private String id;
    private String title;
    private String author;
    private int pages;
    private int year;
    private String isbn;


    public Book(String title, String author, int pages,  int year, String isbn){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.isbn = isbn;
    }

}
package io.company.library.model;

//https://projectlombok.org/features/all
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Data @Builder
@Document("books")
public class Book {

	@Id
    private String id;
    private String title;
    private String author;
    private int pages;
    private int year;
    private String isbn;
    private boolean isLiterature;
    private String imageId;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
    @Version
    Long version;

    public Book(String title, String author, int pages,  int year, String isbn, boolean isLiterature){
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.isbn = isbn;
        this.isLiterature = isLiterature;
    }

}
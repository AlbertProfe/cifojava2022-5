package io.company.library.model;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity(name="Author")
@Table(name="AUTHOR_TABLE")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AUTHOR_ID")
    private  long authorId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name = "AGE")
    private int age;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL )
    private List<Book> books = new ArrayList<Book>();

    //constructor without ID
    public Author(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

//    public Author(Long authorId) {
//        this.authorId = authorId;
//    }

    //method to add books to books
    public void addBook(Book book) {
        this.getBooks().add(book);
        if (book.getAuthor() != null) book.getAuthor().getBooks().remove(book);
        book.setAuthor(this);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }
}

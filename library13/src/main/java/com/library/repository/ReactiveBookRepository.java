package com.library.repository;

import com.library.entity.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReactiveBookRepository implements BookRepository {

    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("Orlando", "Virginia Wolf", 1928));
        books.add(new Book("To the lighthouse","Virginia Woolf", 1927));
        books.add(new Book("One room on my own", "Virginia Woolf",1929));
        books.add(new Book("Anna Karenina", "Leon Tolstoy", 1878));
        books.add(new Book("War and Peace", "Leon Tolstoy", 1867));
        books.add(new Book("1984", "George Orwell", 1961));
        books.add(new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", 1892));
    }

    @Override
    public Flux<Book> findAll() {
        //simulate stream data with 2 seconds delay.
        return Flux.fromIterable(books).delayElements(Duration.ofSeconds(1));
    }


}

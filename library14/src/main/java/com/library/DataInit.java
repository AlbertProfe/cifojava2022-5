package com.library;

import com.library.entity.Book;
import com.library.repository.ReactiveBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.Random;

@Component
@Slf4j
@Profile("default")
class DataInit implements CommandLineRunner {

    private final ReactiveBookRepository books;

    public DataInit(ReactiveBookRepository books) {
        this.books = books;
    }

    @Override
    public void run(String[] args) {
        log.info("start data initialization ...");
        Random rand = new Random();
        this.books
                .deleteAll()
                .thenMany(
                        Flux
                                .just("Book #1", "Book #2", "Book #3", "Book #4","Book #5","Book #6","Book #7","Book #8")
                                .flatMap(
                                        title -> this.books.save(Book.builder().title(title).author("author of " + title).year(rand.nextInt(1900,2022)).isbn("isbn of " + title).build())
                                )
                )
                .thenMany(
                        this.books.findAll()
                )
                .subscribe(
                        data -> log.info("found books: {}", books),
                        error -> log.error("" + error),
                        () -> log.info("done initialization...")
                );

    }

}

//https://github.com/hantsy/spring-reactive-sample/blob/master/boot-data-mongo/src/main/java/com/example/demo/DemoApplication.java
//https://hantsy.github.io/spring-reactive-sample/data/data-mongo.html
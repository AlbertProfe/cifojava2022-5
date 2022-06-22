package com.library.controller;


import com.library.entity.Book;
import com.library.repository.ReactiveBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@EnableAsync
public class BookRestController {

    @Autowired
    private ReactiveBookRepository bookRepository;

    @GetMapping(path = "/books", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getBooks () {
        return bookRepository.findAll();

    }

    @PostMapping("/save")
    public Mono<Book> saveBook(@RequestBody final Book book){
       //System.out.println("executed" + book);
       return  bookRepository.save(book);
    }


}

package com.library.repository;

import com.library.entity.Book;
import reactor.core.publisher.Flux;

public interface BookRepository {
    Flux<Book> findAll();

}

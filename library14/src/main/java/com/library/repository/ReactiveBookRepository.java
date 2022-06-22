package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveBookRepository extends ReactiveMongoRepository<Book, String> {



}

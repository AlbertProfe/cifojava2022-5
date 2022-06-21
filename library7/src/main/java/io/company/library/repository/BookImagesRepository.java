package io.company.library.repository;

import io.company.library.model.Book;
import io.company.library.model.BookImages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookImagesRepository  extends MongoRepository<BookImages, String> {
}

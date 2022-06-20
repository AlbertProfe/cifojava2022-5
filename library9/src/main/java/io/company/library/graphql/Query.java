package io.company.library.graphql;

import io.company.library.model.Author;
import io.company.library.model.Book;
import io.company.library.repository.AuthorRepository;
import io.company.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
    AuthorRepository authorRepository;
    BookRepository bookRepository;
    @Autowired
    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    public long countBooks() {
        return bookRepository.count();
    }
}



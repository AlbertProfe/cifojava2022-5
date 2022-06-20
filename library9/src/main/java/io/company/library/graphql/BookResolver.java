package io.company.library.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import io.company.library.model.Author;
import io.company.library.model.Book;
import io.company.library.repository.AuthorRepository;
import io.company.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    @Autowired
    AuthorRepository authorRepository;
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getAuthorId())
                .orElseThrow(null);
    }




}

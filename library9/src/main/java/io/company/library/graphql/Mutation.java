package io.company.library.graphql;

import io.company.library.model.Author;
import io.company.library.model.Book;
import io.company.library.repository.AuthorRepository;
import io.company.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import java.util.*;

public class Mutation implements GraphQLMutationResolver {
    AuthorRepository authorRepository;
    BookRepository bookRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(String firstName, String lastName, int age){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAge(age);
        authorRepository.save(author);
        return author;
    }
    public Book createBook (String title, int pages, int publishedYear, String isbn, Long authorId) {
        Book book = new Book();
        Optional<Author> author =  authorRepository.findById(authorId);
        if (author.isPresent())  book.setAuthor(author.get());
        book.setTitle(title);
        book.setPages(pages);
        book.setPublishedYear(publishedYear);
        book.setIsbn(isbn);
        bookRepository.save(book);
        return book;
    }
    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBook(Long bookId, String title, int pages, int publishedYear, String isbn) {
        Optional<Book> dataBook = bookRepository.findById(bookId);
        if (dataBook.isPresent()) {
            Book book = dataBook.get();
            if (title != null)
                book.setTitle(title);
            if (isbn != null)
                book.setIsbn(isbn);
            if (pages != 0)
                book.setPages(pages);
            if (publishedYear != 0)
                book.setPublishedYear(publishedYear);
            bookRepository.save(book);
            return book;
        } else return null;
    }
}

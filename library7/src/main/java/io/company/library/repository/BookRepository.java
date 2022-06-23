package io.company.library.repository;

import io.company.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    
    @Query("{'isLiterature':true}")
    List<Book> findAllisLiterature();

    @Query("{ 'year' : { $gt: ?0, $lt: ?1 } }")
    List<Book> findBooksByYearBetween(int yearGT, int yearLT);

    @Query("{ pages : ?0 }")
    List<Book> getBooksByPages(int pages);

    @Query("{pages : {$lt: ?0}}")
    List<Book> getBooksByPagesLower(int pages);

    @Query("{ pages : { $gte: ?0 } }")
    List<Book> getBooksByPagesGreater(int pages);

    @Query("{author : ?0}")
    List<Book> getBooksByAuthor(String author);

    @Query("{author: ?0, year: ?1}")
    List<Book> getBooksByAuthorAndYear(String author, Integer year);

    @Query("{$and :[{author: ?0},{year: ?1}] }")
    List<Book> findBooksByAuthorAndYear(String author, Integer year);

    @Query("{$or :[{author: ?0},{year: ?1}] }")
    List<Book> getBooksByAuthorOrYear(String author, Integer year);

    @Query("{'author' : ?0, 'year' : ?1}")
    List<Book> findByAuthorAndYear(String author, int year);

    @Query("{'author' : :#{#author}, 'category' : :#{#year}}")
    List<Book> findNamedParameters(@Param("author") String author, @Param("year") String year);

    @Query("{'author' : ?0}")
    Page<Book> findBy(String author, Pageable pageable);

    @Query("{\n" +
            "author : { $in : ?0},\n" +
            "pages : { $gt : ?1, $lt : ?2},\n" +
            "year : {$nin : ?3}\n" +
            "}")
    List<Book> findBy(String[] authors, int pageGT, int pageLT, int[] excludeYears);

    Optional<Book> findBookById(String id);

    void deleteBookById(String id);
}
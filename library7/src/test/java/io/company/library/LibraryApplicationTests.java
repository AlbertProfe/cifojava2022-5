package io.company.library;

import io.company.library.model.Book;
import io.company.library.repository.BookRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LibraryApplicationTests {

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createBooks() {
		logger.info("Welcome to test MongoDB");
		logger.info("Data creation Books started...");

		Timestamp startCreateTwo = new Timestamp(System.currentTimeMillis());
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));
		Timestamp finishCreteTwo = new Timestamp(System.currentTimeMillis());

		logger.info("duration create 60 operations ... : " + (finishCreteTwo.getTime() - startCreateTwo.getTime()) + " (ms)");
		logger.info("Data creation Books complete...");


	}


	@Test
	void ListAllBooks() {
		logger.info("Welcome to test MongoDB");
		logger.info("Data findAll Books started...");

		Timestamp startCreateList = new Timestamp(System.currentTimeMillis());
		List<Book> books = bookRepository.findAll();
		Timestamp finishCreateList = new Timestamp(System.currentTimeMillis());
		logger.info("duration list 1 operations ... : " + (finishCreateList.getTime() - startCreateList.getTime()) + " (ms) " + bookRepository.count());
		logger.info("Data list Book complete...");
		logger.info("Data list Book :" + books);
	}

	@Test
	void ListOneBook() {
		logger.info("Welcome to test MongoDB");
		logger.info("Data findOne Book started...");

		Timestamp startFindOne = new Timestamp(System.currentTimeMillis());
		Optional<Book> foundBook = bookRepository.findById("62b17401fbb3ab3e916be693");
		Timestamp finishFindOne = new Timestamp(System.currentTimeMillis());
		logger.info("duration findOne ... : " + (finishFindOne.getTime() - startFindOne.getTime()) + " (ms) " + foundBook.get());
		logger.info("Data findBook one Book complete...");

	}

	@Test
	void DeleteOneBook() {
		logger.info("Welcome to test MongoDB");
		logger.info("Data deleteOne Book started...");

		Timestamp startDeleteOne = new Timestamp(System.currentTimeMillis());
		bookRepository.deleteById("62b17401fbb3ab3e916be693");
		Timestamp finishDeleteONne = new Timestamp(System.currentTimeMillis());
		logger.info("duration findOne ... : " + (finishDeleteONne.getTime() - startDeleteOne.getTime()) + " (ms) ");
		logger.info("Data delete complete...");

	}




}

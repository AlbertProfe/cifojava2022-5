package io.company.library;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableMongoRepositories
public class ApplicationCommandRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Welcome to the runner from commandLineRunner to test MongoDB");
        logger.info("Data creation Employee started...");

        Timestamp startCreateTwo = new Timestamp(System.currentTimeMillis());
        bookRepository.save(new Book("Orlando", "Virginia Wolf", 125, 1929, "W54GWWT54GWFG5"));
        bookRepository.save(new Book("To the lighthouse","Virginia Wolf", 625, 1931, "W54G34tfg344GWFG5"));

        Timestamp finishCreteTwo = new Timestamp(System.currentTimeMillis());

        logger.info("duration create 2 operations ... : " + (finishCreteTwo.getTime() - startCreateTwo.getTime()) + " (ms)");
        logger.info("Data creation Employee complete...");



    }

}
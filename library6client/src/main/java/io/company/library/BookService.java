package io.company.library;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    //this object will make some request HTTP (get, post, put, delete) in order
    //to send/receive JSON data from API REST endpoint
    RestTemplate restTemplate  = new RestTemplate();

    public Iterable<Book> getAllBooks() {
        //
        ResponseEntity<List<Book>> response = restTemplate.exchange(
                "http://localhost:8080/api/books",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Book>>() {}
        );
        List<Book> books = response.getBody();
        return books;
    }

    public void createBook(Book book) {
        //
        HttpEntity<Book> request = new HttpEntity<>(book);
        restTemplate.postForObject("http://localhost:8080/webapi/books", request, Book.class);
    }

    public void deleteBookById(Long id) {
        //
        restTemplate.delete("http://localhost:8080/webapi/books/" + id);
    }

    public Optional<Book> findBookById(Long id) {
        return null;
    }
}



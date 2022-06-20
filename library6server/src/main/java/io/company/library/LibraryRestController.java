package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class LibraryRestController {
    //here we are creating our end-point rest API
    @Autowired
    BookService bookservice;

    //CRUD: read
    @GetMapping("books")
    public Iterable<Book> getAllBooks() {
        //
        return bookservice.getAllBooks();
    }

    //CRUD: read, find one book by id
    @GetMapping("getBook")
    public Book findBookById(Long id){
        //
        Optional<Book> bookFound = bookservice.findBookById(id);
        if (bookFound.isPresent()) return  bookFound.get();

        return null;
    }

    //CRUD: create
    @PostMapping(path="addBook", consumes = "application/JSON")
    public Book addBook(@RequestBody Book book){
        //
        Book bookCreated = bookservice.createBook(book);
        return bookCreated ;
    }

    //CRUD: delete
    @DeleteMapping("deleteBook")
    public ResponseEntity<Book> deleteBook (@RequestParam Long id) {
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteBook");
        headers.add("version","api 1.0");

        Optional<Book> bookFound  = bookservice.findBookById(id);
        boolean isBook = bookFound.isPresent();
        if(isBook) {
            //Optional<Book> deletedBook = bookservice.deleteBookById(id);
            bookservice.deleteBookById(id);
            headers.add("operationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(bookFound.get());
        } else return ResponseEntity.accepted().body(null);


    }

    //CRUD: update
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable Long id, @RequestBody Book dataBook) {

        Optional<Book> bookFound = bookservice.findBookById(id);

        if (bookFound.isPresent()) {
            Book bookToUpdate = bookFound.get();
            //
            if  (dataBook.getTitle() != null) {
                bookToUpdate.setTitle(dataBook.getTitle());
            }

            Book bookUpdated = bookservice.updateBook(bookToUpdate);
            return ResponseEntity.accepted().body(bookUpdated);
        } else
            return ResponseEntity.accepted().body(null);

    }

    //CRUD: delete book by title
    @DeleteMapping("deleteBookByTitle")
    public ResponseEntity<Book> deleteBookByTitle (@RequestParam String title) {
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteBookByTitle");
        headers.add("version","api 1.0");

        //findBookByTitle(String title)
        //deleteBookByTitle(String title)

        return null;

    }


}

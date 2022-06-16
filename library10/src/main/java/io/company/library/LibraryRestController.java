package io.company.library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:8080", methods={RequestMethod.GET,RequestMethod.POST})
public class LibraryRestController {

    @Autowired
    BookService bookService;


    @GetMapping("getBooks")
    public Iterable<Book> getBooks() {
        //
        return bookService.getAllBooks();

    }

    @PostMapping(path="createBook", consumes = "application/JSON")
    public Book addBook(@RequestBody Book book){
        //
        Book bookCreated = bookService.createBook(book);
        return bookCreated ;
    }
}

package io.company.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api")
public class LibraryRestController {
    @Autowired
    BookRepository bookrepository;

    //here we are creating our end-point rest API
    @GetMapping("books")
    public List<Book> getAllBooks() {
        return bookrepository.findAll();
    }


}

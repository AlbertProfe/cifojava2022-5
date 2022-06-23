package io.company.library.webcontroller;

import io.company.library.model.Book;
import io.company.library.model.BookImages;
import io.company.library.repository.BookImagesRepository;
import io.company.library.repository.BookRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("web")
public class WebBookController {

    @Autowired
    BookRepository bookrepository;
    @Autowired
    BookImagesRepository bookImagesRepository;

    @RequestMapping("home")
    public String getWeb (Model containerToView) {

        containerToView.addAttribute("booksfromController",
                bookrepository.findAll());
        containerToView.addAttribute("miabuela",
                "too much love");
        containerToView.addAttribute("qty students in this class",
                25);
        //System.out.println("Controller Web request ...");
        return "web";
    }

    @RequestMapping("/newBook")
    public String newBook() {
        return "newBook";
    }

    @RequestMapping("/insertBook")
    public String insertBook(Book book) {
        //
        bookrepository.save(book);
        return "redirect:/web/home";
    }

    @RequestMapping("deleteBook")
    public String deleteBook(@RequestParam("id") String id){
        //
        //System.out.println("bookId" + id);
        bookrepository.deleteBookById(id);
        return "redirect:/web/home";
    }

    @RequestMapping("detailBook")
    public String detailBook(@RequestParam("id") String id, Model model){
        //
        Optional<Book> bookFound = bookrepository.findBookById(id);
        if (bookFound.isPresent()) {
            model.addAttribute("bookfromController", bookFound.get());
            return "detailBook.html";
        } else return "notfound.html";


    }

    @GetMapping("bookImage")
    public String uploadookImages(){
        System.out.println("bookImage");
        return "uploadImagesBook.html";
    }

    @PostMapping("sendBookImage")
    public String sendBookImage ( @RequestParam("file") MultipartFile file) throws IOException {

        BookImages bookImage  = new BookImages();
        bookImage.setName("test");
        bookImage.setImage( new Binary(file.getBytes() ));

        bookImagesRepository.save(bookImage);

        return "redirect:/web/home";


    }





}
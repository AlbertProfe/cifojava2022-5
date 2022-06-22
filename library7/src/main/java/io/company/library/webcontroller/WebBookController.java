package io.company.library.webcontroller;

import io.company.library.model.BookImages;
import io.company.library.repository.BookImagesRepository;
import io.company.library.repository.BookRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

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

    @RequestMapping("removeBook")
    public String deleteBook(@RequestParam String titleFromView){
        //
        System.out.println("bookTilte" + titleFromView);
        return "bookdeleted";
    }

    @GetMapping("bookImage")
    public String uploadookImages(){
        System.out.println("bookImage");
        return "uploadImagesBook.html";
    }

    @PostMapping("sendBookImage")
    public String sendBookImage ( @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        BookImages bookImage  = new BookImages();
        bookImage.setName("test");
        bookImage.setImage( new Binary(file.getBytes() ));

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        bookImagesRepository.save(bookImage);

        return "redirect:/web/home";


    }





}
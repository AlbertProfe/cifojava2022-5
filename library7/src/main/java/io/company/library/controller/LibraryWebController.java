package io.company.library.controller;

import io.company.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/library")
public class LibraryWebController {

    @Autowired
    BookRepository bookrepository;

    @RequestMapping("/home")
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

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam String titleFromView){

        System.out.println("bookTilte" + titleFromView);

        return "bookdeleted";


    }

    @RequestMapping("/updateBookImages")
    public String updateBookImages(){
        return "uploadImagesBook";


    }



}
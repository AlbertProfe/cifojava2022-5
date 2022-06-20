//package io.company.library;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/mylibrary")
//public class LibraryWebController {
//
//    @Autowired
//    BookService bookService;
//
//    @RequestMapping("/home")
//    public String getWeb (Model containerToView) {
//
//        containerToView.addAttribute("booksfromController",
//                bookService.queryBooksFromArray());
//        containerToView.addAttribute("miabuela",
//                "too much love");
//        containerToView.addAttribute("qty students in this class",
//                25);
//
//
//        //System.out.println("Controller Web request ...");
//
//        return "web";
//    }
//
//    @RequestMapping("/deleteBook")
//    public String deleteBook(@RequestParam String titleFromView){
//
//        System.out.println("bookTilte" + titleFromView);
//
//        return "bookdeleted";
//
//
//    }
//
//
//}
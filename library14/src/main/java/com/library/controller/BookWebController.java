package com.library.controller;


import com.library.entity.Book;
import com.library.repository.ReactiveBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;


@Controller
@EnableAsync
public class BookWebController {

    @Autowired
    private ReactiveBookRepository bookRepository;

    @RequestMapping(path = "/home")
    public String index(final Model model) {
        Flux<Book> bookFlux = bookRepository.findAll().delayElements(Duration.ofSeconds(1));

        // loads 1 and display 1, stream data, data driven mode.
//        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
//                new ReactiveDataDriverContextVariable(bookRepository.findAll(), 1);

        model.addAttribute("books", new ReactiveDataDriverContextVariable(bookFlux, 1));

        // classic, wait repository loaded all and display it.
        //model.addAttribute("books", bookRepository.findAll());

        return "books";

    }

}

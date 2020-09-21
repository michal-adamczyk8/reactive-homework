package com.kodilla.webflux.controller;


import com.kodilla.webflux.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping("/strings")
    public Flux<String> getStrings() {
        return Flux.just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping("/books")
    public Flux<Book> getBooks() {
        Book b1 = new Book("Title1", "Author1", 2000);
        Book b2 = new Book("Title2", "Author2", 2001);
        Book b3 = new Book("Title3", "Author1", 2000);
        Book b4 = new Book("Title4", "Author2", 2001);
        return Flux.just(b1, b2, b3, b4)
                .log();
    }
}

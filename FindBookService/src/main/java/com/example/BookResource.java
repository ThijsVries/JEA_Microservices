package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {
    
    @Autowired
    private BookRepository bookRepo;
    
    @RequestMapping(value = "books/{title}", method = RequestMethod.GET)
    public Book retrieveBookByName(@PathVariable("title") String title){
        return bookRepo.findByTitle(title).get(0);
    }
}

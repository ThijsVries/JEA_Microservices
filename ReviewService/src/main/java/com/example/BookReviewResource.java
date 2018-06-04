package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookReviewResource {
    
    @Autowired
    private BookReviewRepository bookRepo;
    
    @RequestMapping(value = "bookreviews/{id}", method = RequestMethod.GET)
    public BookReview retrieveByBoodId(@PathVariable("id") String id){
        return bookRepo.findByBookId(Long.parseLong(id)).get(0);
    }
}

package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookProductResource {
    
    @Autowired
    private BookProductRepository repo;
    
    @RequestMapping(value = "bookproducts/{id}", method = RequestMethod.GET)
    public BookProduct retrieveByBoodId(@PathVariable("id") String id){
        return repo.findByBookId(Long.parseLong(id)).get(0);
    }
}

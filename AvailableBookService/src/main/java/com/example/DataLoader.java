package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    private BookProductRepository bookRepo;
    
    @Autowired
    public DataLoader(BookProductRepository repo){
        this.bookRepo = repo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookRepo.save(new BookProduct(1L, 1245, 12.50));
        bookRepo.save(new BookProduct(2L, 135, 8.75));
        bookRepo.save(new BookProduct(3L, 45, 20.00));
        bookRepo.save(new BookProduct(4L, 135, 5.00));
    }
}

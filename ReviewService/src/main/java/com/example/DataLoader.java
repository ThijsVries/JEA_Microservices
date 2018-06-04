package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{
    
    private BookReviewRepository bookRepo;
    
    @Autowired
    public DataLoader(BookReviewRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookRepo.save(new BookReview(1L, "Good book", "4/5"));
        bookRepo.save(new BookReview(1L, "Not so good book", "2/5"));
        bookRepo.save(new BookReview(1L, "I liked it", "4/5"));
        bookRepo.save(new BookReview(2L, "Garbage", "1/5"));
        bookRepo.save(new BookReview(4L, "Godlike", "5/5"));
        bookRepo.save(new BookReview(3L, "Very nice", "10/5"));
        bookRepo.save(new BookReview(2L, "The book of 1990!!", "5/5"));
        bookRepo.save(new BookReview(3L, "A must have", "4/5"));
    }
    
    

}

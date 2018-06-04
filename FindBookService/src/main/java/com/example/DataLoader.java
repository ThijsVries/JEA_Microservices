package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private BookRepository repo;

    @Autowired
    public DataLoader(BookRepository bookrepo) {
        this.repo = bookrepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">>>>>>>>>HELLO WORLD");
        repo.save(new Book("Swag-book-I", "Mr. Swag", "Horror", "Pristine"));
        repo.save(new Book("Swag-book-II", "Mr. Swag", "Horror", "Mint"));
        repo.save(new Book("No-idea", "???", "Fiction", "Pristine"));
        repo.save(new Book("JPA-tutorial", "Some guy", "Horror", "Badly damaged"));
    }

}

package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicApplication {

    private static final Logger log = LoggerFactory.getLogger(BasicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
    
//    @Bean
//    public CommandLineRunner demo(BookRepository repo){
//        return (args) -> {
//            repo.save(new Book("Swag book I", "Mr. Swag", "Horror", "Pristine"));
//            repo.save(new Book("Swag book II", "Mr. Swag", "Horror", "Mint"));
//            repo.save(new Book("No idea", "???", "Fiction", "Pristine"));
//            repo.save(new Book("JPA tutorial", "Some guy", "Horror", "Badly damaged"));
//            
//            for(Book book : repo.findAll()){
//                log.info(book.getTitle());
//            }
//        };
//    }
}

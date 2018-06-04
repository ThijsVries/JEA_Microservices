package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public Book(String title, String author, String genre, String condition) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.condition = condition;
    }
    
    public Book(Long id, String title, String author, String genre, String condition) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.condition = condition;
    }
    
    protected Book(){
        
    }
}

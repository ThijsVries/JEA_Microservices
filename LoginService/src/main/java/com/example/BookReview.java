package com.example;

public class BookReview {

    private Long id;
    private Long bookId;
    private String review;
    private String rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    protected BookReview(){
        
    }

    public BookReview(Long bookId, String review, String rating) {
        this.bookId = bookId;
        this.review = review;
        this.rating = rating;
    }
}

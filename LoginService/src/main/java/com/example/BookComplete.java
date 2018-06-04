package com.example;


public class BookComplete {
    
    private Book bookInfo;
    private BookProduct bookProduct;
    private BookReview bookReview;

    public Book getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }

    public BookProduct getBookProduct() {
        return bookProduct;
    }

    public void setBookProduct(BookProduct bookProduct) {
        this.bookProduct = bookProduct;
    }

    public BookReview getBookReview() {
        return bookReview;
    }

    public void setBookReview(BookReview bookReview) {
        this.bookReview = bookReview;
    }
    
    
    
    public BookComplete(Book book, BookProduct product, BookReview review){
        this.bookInfo = book;
        this.bookProduct = product;
        this.bookReview = review;
    }

}

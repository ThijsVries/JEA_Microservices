package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private int amountAvailable;
    private double pricePerProduct;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public double getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(double pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }
    
    protected BookProduct(){
        
    }

    public BookProduct(Long bookId, int amountAvailable, double pricePerProduct) {
        this.bookId = bookId;
        this.amountAvailable = amountAvailable;
        this.pricePerProduct = pricePerProduct;
    }
    
    
}

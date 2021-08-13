package com.enigma.bookStore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private Integer year;

    private Integer pages;

    private String language;

    private String publisher;

    private Integer price;
    private Integer stock;

    @Column(name = "purchase_amount")
    private Integer purchaseAmount = 0;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<MemberhasBooks> trx = new ArrayList<>();

    public Book() {
    }

    public Book(Integer id, String title, String description, Integer year, Integer pages, String language, String publisher, Integer price, Integer stock, Integer purchaseAmount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.pages = pages;
        this.language = language;
        this.publisher = publisher;
        this.price = price;
        this.stock = stock;
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}

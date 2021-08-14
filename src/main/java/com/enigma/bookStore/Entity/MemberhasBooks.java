package com.enigma.bookStore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "member_has_books")
public class MemberhasBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnoreProperties("trx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("trx")
    private Book book;

    private Integer quantity;

    private Integer totalPrice;

    public MemberhasBooks() {
    }

    public MemberhasBooks( Member member, Book book, Integer quantity, Integer totalPrice) {
        this.member = member;
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}

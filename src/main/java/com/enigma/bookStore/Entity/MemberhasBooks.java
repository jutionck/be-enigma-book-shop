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
}

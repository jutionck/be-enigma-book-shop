package com.enigma.bookStore.dto;

public class RequestTransactions {

    private Integer memberId;

    private Integer[] bookId;

    private Integer quantity;

    private Integer totalPrice;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer[] getBookId() {
        return bookId;
    }

    public void setBookId(Integer[] bookId) {
        this.bookId = bookId;
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

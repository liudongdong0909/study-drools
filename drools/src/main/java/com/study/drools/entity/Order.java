package com.study.drools.entity;

import java.time.LocalDate;

/**
 * @author walle
 * @version 1.0
 * @create 2019-03-10
 */
public class Order {

    private LocalDate bookingDate;

    private Integer score;

    private Integer amount;

    private User user;

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.airline.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;
    private Long transaction_id;
    private String payment_method;
    private String payment_status;
    private Double amount;
    private LocalDateTime payment_date;
    private String response_code;
    private String response_message;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking_id() {
        return booking;
    }



    public void setBooking_id(Booking booking) {
        this.booking = booking;
    }


    public Long getTransaction_id() {
        return transaction_id;
    }



    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }


    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }


    public String getPayment_status() {
        return payment_status;
    }


    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }


    public Double getAmount() {
        return amount;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public LocalDateTime getPayment_date() {
        return payment_date;
    }


    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }


    public String getResponse_code() {
        return response_code;
    }


    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }


    public String getResponse_message() {
        return response_message;
    }


    public LocalDateTime getCreated_at() {
        return created_at;
    }    


    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


    public LocalDateTime getUpdated_at() {
        return updated_at;
    }


    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }


    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }
    
}

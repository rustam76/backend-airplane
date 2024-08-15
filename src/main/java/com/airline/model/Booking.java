package com.airline.model;

import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private String booking_code;
    private LocalDateTime booking_date;
    private Long passeger_id;
    private String status;
    private Double total_amount;
    private Long payment_id;


    public Booking(Long id, String booking_code, LocalDateTime booking_date, Long passeger_id, String status, Double total_amount, Long payment_id) {
        this.id = id;
        this.booking_code = booking_code;
        this.booking_date = booking_date;
        this.passeger_id = passeger_id;
        this.status = status;
        this.total_amount = total_amount;
        this.payment_id = payment_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBooking_code() {
        return booking_code;
    }

    public void setBooking_code(String booking_code) {
        this.booking_code = booking_code;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDateTime booking_date) {
        this.booking_date = booking_date;
    }

    public Long getPasseger_id() {

        return passeger_id;
    }

    public void setPasseger_id(Long passeger_id) {
        this.passeger_id = passeger_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Long getPayment_id() {
        return payment_id;
    }
}

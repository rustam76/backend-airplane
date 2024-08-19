package com.airline.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String booking_code;
    private LocalDateTime booking_date;

    @ManyToOne
    @JoinColumn(name = "passeger_id", referencedColumnName = "id")
    private Passenger passeger;
    private String status;
    private Double total_amount;

    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;


    public Booking(Long id, String booking_code, LocalDateTime booking_date, Passenger passeger, String status, Double total_amount, Payment payment) {
        this.id = id;
        this.booking_code = booking_code;
        this.booking_date = booking_date;
        this.passeger = passeger;
        this.status = status;
        this.total_amount = total_amount;
        this.payment = payment;
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

    public Passenger getPasseger_id() {

        return passeger;
    }

    public void setPasseger_id(Passenger passeger) {
        this.passeger = passeger;
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

    public Payment getPayment_id() {
        return payment;
    }


    public void setPayment_id(Payment payment) {
        this.payment = payment;
    }

}

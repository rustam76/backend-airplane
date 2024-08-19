package com.airline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_detail")
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;


    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;
    

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seats seats;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private Discount discount;


    public BookingDetail() { }


    public BookingDetail(Long id, Booking booking, Flight flight, Seats seats, Double price, Discount discount) {
        this.id = id;
        this.booking = booking;
        this.flight = flight;
        this.seats = seats;
        this.price = price;
        this.discount = discount;
    }

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

    public Flight getFlight_id() {
        return flight;
    }

    public void setFlight_id(Flight flight) {
        this.flight = flight;
    }

    public Seats getSeat_id() {
        return seats;
    }

    public void setSeat_id(Seats seats) {
        this.seats = seats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Discount getDiscount_id() {
        return discount;
    }

    public void setDiscount_id(Discount discount) {
        this.discount = discount;
    }

    
}

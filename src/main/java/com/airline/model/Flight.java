package com.airline.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
    private Long id;

    private String flight_number;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;
    
    @ManyToOne
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id")
    private Airport departure_airport_id;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id")
    private Airport arrival_airport_id;
    
    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "id")
    private Airline airline_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    public LocalDateTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalDateTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Airport getDeparture_airport_id() {
        return departure_airport_id;
    }

    public void setDeparture_airport_id(Airport departure_airport_id) {
        this.departure_airport_id = departure_airport_id;
    }


    public Airport getArrival_airport_id() {
        return arrival_airport_id;
    }

    public void setArrival_airport_id(Airport arrival_airport_id) {  
        this.arrival_airport_id = arrival_airport_id;
    }

    public Airline getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(Airline airline_id) {
        this.airline_id = airline_id;
    }



}

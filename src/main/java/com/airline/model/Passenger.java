package com.airline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fisrt_name;
    private String last_name;
    private String email;
    private String phone_number;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFisrt_name() {
        return fisrt_name;
    }


    public void setFisrt_name(String fisrt_name) {
        this.fisrt_name = fisrt_name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone_number;
    }


    public void setPhone(String phone_number) {
        this.phone_number = phone_number;
    }

}
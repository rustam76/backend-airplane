package com.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airline.model.Airport;
import com.airline.repository.AirportRepository;

@Service
public class AirportService {

    private final AirportRepository airportRepository;


    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }


    public Airport findById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }


    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }
    

    public Airport update(Airport airport, Long id) {
        airport.setId(id);
        return airportRepository.save(airport);
    }


    public void delete(Long id) {
        airportRepository.deleteById(id);
    }
}

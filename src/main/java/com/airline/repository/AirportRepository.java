package com.airline.repository;
import com.airline.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
}

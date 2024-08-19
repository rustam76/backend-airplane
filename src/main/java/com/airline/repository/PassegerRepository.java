package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airline.model.Passenger;

public interface PassegerRepository extends JpaRepository<Passenger, Long> {
    
}

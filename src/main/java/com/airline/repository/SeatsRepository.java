package com.airline.repository;
import com.airline.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SeatsRepository extends JpaRepository<Seats, Long> {
    
}

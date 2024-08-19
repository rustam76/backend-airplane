package com.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airline.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    
    Optional<User> findByEmail(String email);
    // public User findByEmail(String email);
    public User findByUsername(String username);

}

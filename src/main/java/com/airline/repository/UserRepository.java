package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airline.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
  
    public User findByEmail(String email);
    public User findByUsername(String username);


}

package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Service;

import com.airline.dto.user.LoginDTO;
import com.airline.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private Authentication authenticate;

    public boolean authenticate(LoginDTO input) {
        String username = input.getUsername();
        String password = input.getPassword();

        if (userRepository.findByUsername(username) != null && userRepository.findByUsername(username).getPassword().equals(password)) {
            return true;
        }

        if (userRepository.findByEmail(username) != null && userRepository.findByEmail(username).orElseGet(null).getPassword().equals(password)) {
            return true;
        }


        return false;
    }


    public boolean register(String username, String email, String password) {
        return false;
    }


    public boolean userExists(String email,  String username) {
        return false;
    }


    public boolean emailExists(String email) {
        return false;
    }
    
}

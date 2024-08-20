package com.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airline.dto.user.LoginDTO;
import com.airline.dto.user.RegisterDTO;
import com.airline.model.Role;
import com.airline.model.User;
import com.airline.repository.RoleRepository;
import com.airline.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    // private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    // private Authentication authenticate;

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


    public User register(RegisterDTO input) {
        // Encrypt the password
        Role role = roleRepository.findByName(input.getRoleName())
        .orElseThrow(() -> new RuntimeException("Role not found"));
        // String encodedPassword = bCryptPasswordEncoder.encode(input.getPassword());
    
        // Create the user entity
        var users = new User().setEmail(input.getEmail()).setUsername(input.getUsername()).setPassword(input.getPassword()).setRole(role);

        System.out.println(users);
     
        // Save the user entity to the repository
        return userRepository.save(users);
    }


    public boolean userExists(String email,  String username) {
        return false;
    }


    public boolean emailExists(String email) {
        return false;
    }
    
}

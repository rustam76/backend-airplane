package com.airline.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.airline.User.model.User;
import com.airline.User.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }


     public Page<User> findAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }


    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean userExists(String email,  String username) {
        User userEmail = userRepository.findByEmail(email);
        User userUsername = userRepository.findByUsername(username);
        return userEmail != null || userUsername != null;
    }
}

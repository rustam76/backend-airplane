package com.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.airline.dto.user.UserDTO;
import com.airline.model.User;
import com.airline.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        System.out.println("user: "+user);
        return userRepository.save(user);
    }



     public List<UserDTO> findAllUsers(int page, int size) {
        Page<User> users = userRepository.findAll(PageRequest.of(page, size));
        return users.stream().map(this::converUserToDTO).toList();
    }


    public List<UserDTO> findUserById(Long id) {
        return userRepository.findById(id).stream().map(this::converUserToDTO).toList();
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean userExists(String email,  String username) {
        User userEmail = userRepository.findByEmail(email).orElseThrow();
        User userUsername = userRepository.findByUsername(username);
        return userEmail != null || userUsername != null;
    }



    // // Convert User to UserDTO
    private UserDTO converUserToDTO(User user) {
        UserDTO userDTO = new UserDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getRole().getname(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
        return userDTO;
    } 
}

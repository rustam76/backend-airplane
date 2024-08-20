package com.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.airline.dto.user.LoginDTO;
import com.airline.service.AuthService;
import com.airline.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    
    @Autowired
    private AuthService authService;
    

    @PostMapping(path =  "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> login(@Valid @RequestBody LoginDTO input) {
        log.info("Login: " + input.getUsername() + " " + input.getPassword());

        try {
            String username = input.getUsername();
            String password = input.getPassword();
    
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                ApiResponse<?> apiResponse = new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Username is required"
                );
    
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            var auth = authService.authenticate(input);
            
            ApiResponse<?> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Login successful",
                auth
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
           

        } catch (Exception e) {
            ApiResponse<?> apiResponse = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error"
            );
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

       
        
    }

    @PostMapping("/signup")
    public String register() {
        return "register";
    }

    @PostMapping("/forgot")
    public String forgot() {
        return "forgot";
    }

    
}

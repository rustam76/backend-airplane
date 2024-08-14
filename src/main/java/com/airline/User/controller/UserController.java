package com.airline.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airline.User.model.User;
import com.airline.User.service.UserService;
import com.airline.utils.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired

    private UserService userService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody User user) {
        try {

            if (userService.userExists(user.email, user.username)) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.CONFLICT.value(),
                        "User already exists");
                return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
            }

            userService.saveUser(user);
            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.CREATED.value(),
                    "User created successfully");

            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "internal server error");
            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<User>> getAllUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<User> usersPage = userService.findAllUsers(page, size);

            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Data retrieved successfully",
                    usersPage);

            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "internal server error");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // @GetMapping("/{id}")
    // public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable("id") Long id) {
    //     try {
    //         // User user = userService.findUserById(id);
    //         // ApiResponse<User> apiResponse = new ApiResponse<>(
    //         //         HttpStatus.OK.value(),
    //         //         "Data retrieved successfully",
    //         //         user);
    //         // return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    //     } catch (Exception e) {
    //         ApiResponse<User> apiResponse = new ApiResponse<>(
    //                 HttpStatus.INTERNAL_SERVER_ERROR.value(),
    //                 "internal server error");
    //         return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }


    @DeleteMapping
    public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "User deleted successfully");
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "internal server error");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.airline.controller;

import java.util.List;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.airline.dto.user.CreateUserDTO;
import com.airline.dto.user.UserDTO;
import com.airline.model.Role;
import com.airline.model.User;
// import com.airline.service.RoleService;
import com.airline.service.UserService;
import com.airline.utils.ApiResponse;
import com.airline.utils.Regex;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> saveUser(@Valid @RequestBody CreateUserDTO user) {

        log.info("User: " + user.getEmail() + " " + user.getUsername() + " " + user.getPassword() + " " + user.getRoleid());
        try {

            String username = user.getUsername();
            String email = user.getEmail();
            String password = user.getPassword();
            Long role_id = user.getRoleid();
   

            if (username == null || username.isEmpty() || email == null || email.isEmpty() || password == null
                    || password.isEmpty()) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Username, email and password are required");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            if (role_id == null) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Role is required");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }


            if (Regex.isValidEmail(email) == false) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Email is not valid");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            if (Regex.isValidUsername(username) == false) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Username must be between 3 and 50 characters");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            if (Regex.isValidPassword(password) == false) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "Password must be between 6 and 20 characters");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }


            if (userService.userExists(email, username)) {
                ApiResponse<User> apiResponse = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        "User already exists");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            User userdData = new User();
            Role role = new Role();
         
            role.setId(user.getRoleid());
            userdData.setUsername(user.getUsername());
            userdData.setEmail(user.getEmail());
            userdData.setPassword(user.getPassword());
            userdData.setRole(role);

            // save user
            userService.saveUser(userdData);

            ApiResponse<?> apiResponse = new ApiResponse<>(
                    HttpStatus.CREATED.value(),
                    "User created successfully",
                    user);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal server error");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<UserDTO> usersPage = userService.findAllUsers(page, size);

            if (usersPage.isEmpty()) {
                ApiResponse<?> apiResponse = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "No users found"

                );

                return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
            }

            ApiResponse<List<UserDTO>> apiResponse = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Data retrieved successfully",
                    usersPage);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {

            ApiResponse<Void> apiResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal server error");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findUserById(@PathVariable("id") Long id) {

        try {
            UserDTO user = userService.findUserById(id).get(0);

            ApiResponse<UserDTO> apiResponse = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Data retrieved successfully",
                    user);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) { 

            ApiResponse<User> apiResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Internal server error");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
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

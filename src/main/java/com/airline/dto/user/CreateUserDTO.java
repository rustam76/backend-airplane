package com.airline.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateUserDTO {
    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email address")
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password;

    @NotEmpty(message = "Role is required")
    private Long role_id;


    public CreateUserDTO(String username, String email, String password, Long role_id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {  
        return email;
    }

    public void setEmail(String email) {    
        this.email = email;
    }   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleid() {
        return role_id;
    }
    public void setRoleid(Long role_id) {
        this.role_id = role_id;
    }
    
}

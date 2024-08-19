package com.airline.dto.user;

public class LoginDTO {

    private String username;
    private String password;

    public LoginDTO() {}

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}

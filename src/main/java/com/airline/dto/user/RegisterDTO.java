package com.airline.dto.user;

public class RegisterDTO {
    private String username;
    private String password;
    private String email;
    private String roleName;

    public RegisterDTO(String username, String password, String email, String roleName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
        
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

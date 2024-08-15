package com.airline.utils;

public class Regex {

    public static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isValidUsername(String username) {
        return username.length() >= 3 && username.length() <= 50;
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6 && password.length() <= 20;
    }
    
}

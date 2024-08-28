package com.example.project.security;


import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, User> users = new HashMap<>();

    public AuthService() {
        users.put("admin", new User("admin", hashPassword("password123"), Role.ADMIN));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPasswordHash().equals(hashPassword(password));
    }

    public boolean authorize(String username, Role requiredRole) {
        User user = users.get(username);
        return user != null && user.getRole().equals(requiredRole);
    }

    private String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }
}
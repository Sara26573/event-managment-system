package com.example.eventmanagment.Dto;

public class AuthenticationResponseDTO {
    private String role;
    private String username;
    private Long userId;

    public AuthenticationResponseDTO(String role, String username, Long userId) {
        this.role = role;
        this.username = username;
        this.userId = userId;
    }

    // Getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

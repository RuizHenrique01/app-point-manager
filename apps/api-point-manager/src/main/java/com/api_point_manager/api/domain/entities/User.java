package com.api_point_manager.api.domain.entities;

import java.time.LocalDateTime;

public record User(
    Long id,
    String name,
    String username,
    String email,
    String password,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public User updatePassword(String password){
        return new User(id(), name(), username(), email(), password, createdAt(), updatedAt());
    }

    public User login(String email, String password) {
        return new User(null, null, null, email, password, null, null);
    }
} 

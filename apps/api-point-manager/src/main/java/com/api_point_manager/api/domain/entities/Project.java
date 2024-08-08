package com.api_point_manager.api.domain.entities;

import java.time.LocalDateTime;

public record Project(
    Long id,
    String name,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
} 

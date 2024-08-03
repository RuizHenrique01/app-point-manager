package com.api_point_manager.api.infra.controllers.dtos.project;

import java.time.LocalDateTime;

public record ReadProjectDto(
    Long id,
    String name,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}

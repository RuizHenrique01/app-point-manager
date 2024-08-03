package com.api_point_manager.api.infra.controllers.dtos.project;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectDto(
    @NotBlank
    String name,
    String description
) {
} 

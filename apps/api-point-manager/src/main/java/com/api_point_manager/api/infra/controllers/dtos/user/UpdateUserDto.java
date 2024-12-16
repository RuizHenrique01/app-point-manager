package com.api_point_manager.api.infra.controllers.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(
    @NotBlank
    String name,
    @NotBlank
    String username
) {
} 
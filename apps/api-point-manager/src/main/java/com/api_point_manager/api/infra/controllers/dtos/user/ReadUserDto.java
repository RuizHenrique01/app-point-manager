package com.api_point_manager.api.infra.controllers.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ReadUserDto(
    Long id,
    @NotBlank
    String name,
    @NotBlank
    String username,
    @NotBlank
    @Email(regexp = ".+[@].+[\\.].+")
    String email
) {
} 
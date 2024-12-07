package com.api_point_manager.api.infra.controllers.dtos.user;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
    @NotBlank
    String name,
    @NotBlank
    String username,
    @NotBlank
    @Email(regexp = ".+[@].+[\\.].+")
    String email,
    @NotBlank
    @Length(min = 6)
    String password
) {
} 
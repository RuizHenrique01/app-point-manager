package com.api_point_manager.api.infra.controllers.dtos.project;

public record UpdateProjectDto(
    String name,
    String description
) {
}
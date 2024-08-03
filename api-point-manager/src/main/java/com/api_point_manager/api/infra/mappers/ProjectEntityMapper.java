package com.api_point_manager.api.infra.mappers;

import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;
import com.api_point_manager.api.infra.controllers.dtos.project.ReadProjectDto;
import com.api_point_manager.api.infra.persistence.entities.Project;

public class ProjectEntityMapper {
    public Project toEntity(CreateProjectDto data){
        return new Project(data.name(), data.description());
    }

    public ReadProjectDto toDto(Project data){
        return new ReadProjectDto(
            data.getId(), 
            data.getName(), 
            data.getDescription(), 
            data.getCreatedAt(), 
            data.getUpdatedAt());
    }
}

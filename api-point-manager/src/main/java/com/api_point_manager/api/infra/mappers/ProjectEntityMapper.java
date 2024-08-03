package com.api_point_manager.api.infra.mappers;

import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;
import com.api_point_manager.api.infra.persistence.entities.Project;

public class ProjectEntityMapper {
    public Project toEntity(CreateProjectDto data){
        return new Project(data.name(), data.description());
    }
}

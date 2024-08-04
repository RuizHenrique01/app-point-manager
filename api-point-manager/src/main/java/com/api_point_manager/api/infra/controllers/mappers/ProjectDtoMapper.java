package com.api_point_manager.api.infra.controllers.mappers;

import com.api_point_manager.api.domain.entities.Project;
import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;

public class ProjectDtoMapper {
    public Project toProject(CreateProjectDto data){
        return new Project(null, data.name(), data.description(), null, null);
    }   
}

package com.api_point_manager.api.infra.mappers;

import com.api_point_manager.api.domain.entities.Project;
import com.api_point_manager.api.infra.persistence.entities.ProjectEntity;

public class ProjectEntityMapper {
    public ProjectEntity toEntity(Project data){
        return new ProjectEntity(data.name(), data.description());
    }

    public Project toDomainObj(ProjectEntity data){
        return new Project(
            data.getId(), 
            data.getName(), 
            data.getDescription(), 
            data.getCreatedAt(), 
            data.getUpdatedAt());
    }
}

package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;
import com.api_point_manager.api.infra.persistence.entities.Project;

public class CreateProject extends AbstractUseCase<CreateProjectDto, Project> {

    private final ProjectGateway projectGateway;

    public CreateProject(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public Project execute(CreateProjectDto data) {
        return this.projectGateway.createProject(data);
    }
}

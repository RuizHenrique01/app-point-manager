package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.Project;

public class CreateProject extends AbstractUseCase<Project, Project> {

    private final ProjectGateway projectGateway;

    public CreateProject(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public Project execute(Project data) {
        return this.projectGateway.createProject(data);
    }
}

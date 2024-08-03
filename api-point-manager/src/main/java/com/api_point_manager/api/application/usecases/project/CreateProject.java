package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;
import com.api_point_manager.api.infra.controllers.dtos.project.ReadProjectDto;

public class CreateProject extends AbstractUseCase<CreateProjectDto, ReadProjectDto> {

    private final ProjectGateway projectGateway;

    public CreateProject(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public ReadProjectDto execute(CreateProjectDto data) {
        return this.projectGateway.createProject(data);
    }
}

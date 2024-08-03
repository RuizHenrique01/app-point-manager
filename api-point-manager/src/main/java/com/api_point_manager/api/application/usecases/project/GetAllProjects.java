package com.api_point_manager.api.application.usecases.project;

import java.util.List;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.infra.controllers.dtos.project.ReadProjectDto;

public class GetAllProjects extends AbstractUseCase<Void, List<ReadProjectDto>> {

    private final ProjectGateway projectGateway;

    public GetAllProjects(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public List<ReadProjectDto> execute() {
        return projectGateway.listProjects();
    }
}

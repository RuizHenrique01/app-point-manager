package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.infra.controllers.dtos.project.ReadProjectDto;

public class FindProjectById extends AbstractUseCase<Long, ReadProjectDto> {

    private final ProjectGateway projectGateway;

    public FindProjectById(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public ReadProjectDto execute(Long id) {
        return this.projectGateway.findOneById(id);
    }
}

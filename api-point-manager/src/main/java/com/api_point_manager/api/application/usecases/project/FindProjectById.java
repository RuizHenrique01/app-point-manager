package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.Project;

public class FindProjectById extends AbstractUseCase<Long, Project> {

    private final ProjectGateway projectGateway;

    public FindProjectById(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public Project execute(Long id) {
        return this.projectGateway.findOneById(id);
    }
}

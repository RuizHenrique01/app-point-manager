package com.api_point_manager.api.application.usecases.project;

import java.util.List;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.infra.persistence.entities.Project;

public class GetAllProjects extends AbstractUseCase<Void, List<Project>> {

    private final ProjectGateway projectGateway;

    public GetAllProjects(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public List<Project> execute() {
        return projectGateway.listProjects();
    }
}

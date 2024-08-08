package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.exceptions.NotFoundException;
import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.Project;

public class UpdateProject extends AbstractUseCase<Project, Project> {

    private final ProjectGateway projectGateway;

    public UpdateProject(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public Project execute(Project data) {
        var project = this.projectGateway.findOneById(data.id());

        if(project == null){
            throw new NotFoundException("Projeto não encontrado!");
        }
        
        var projectUpdated = this.projectGateway.updateProject(data);

        return projectUpdated;
    }
}

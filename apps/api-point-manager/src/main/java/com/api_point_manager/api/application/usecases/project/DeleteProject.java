package com.api_point_manager.api.application.usecases.project;

import com.api_point_manager.api.application.exceptions.NotFoundException;
import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.Project;

public class DeleteProject extends AbstractUseCase<Long, Project> {

    private final ProjectGateway projectGateway;

    public DeleteProject(ProjectGateway projectGateway){
        this.projectGateway = projectGateway;
    }

    @Override
    public Project execute(Long id) {
        var project = this.projectGateway.findOneById(id);

        if(project == null){
            throw new NotFoundException("Projeto não encontrado!");
        }
        
        this.projectGateway.deleteProject(id);

        return project;
    }
}

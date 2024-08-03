package com.api_point_manager.api.infra.gateways;

import java.util.List;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.infra.persistence.entities.Project;
import com.api_point_manager.api.infra.persistence.repositories.ProjectRepository;

public class ProjectRepositoryGateway implements ProjectGateway{

    private final ProjectRepository projectRepository;

    public ProjectRepositoryGateway(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> listProjects() {
        return this.projectRepository.findAll();
    }
    
}

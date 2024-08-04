package com.api_point_manager.api.infra.gateways;

import java.util.List;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.domain.entities.Project;
import com.api_point_manager.api.infra.mappers.ProjectEntityMapper;
import com.api_point_manager.api.infra.persistence.entities.ProjectEntity;
import com.api_point_manager.api.infra.persistence.repositories.ProjectRepository;

public class ProjectRepositoryGateway implements ProjectGateway{

    private final ProjectRepository projectRepository;
    private final ProjectEntityMapper projectEntityMapper;

    public ProjectRepositoryGateway(ProjectRepository projectRepository, ProjectEntityMapper projectEntityMapper){
        this.projectRepository = projectRepository;
        this.projectEntityMapper = projectEntityMapper;
    }

    @Override
    public List<Project> listProjects() {
        var projects = this.projectRepository.findAll().stream().map(project -> {
            return this.projectEntityMapper.toDomainObj(project);
        }).toList();
        return projects;
    }

    @Override
    public Project createProject(Project data) {
        ProjectEntity project = this.projectEntityMapper.toEntity(data);
        ProjectEntity createdProject = this.projectRepository.save(project);
        return this.projectEntityMapper.toDomainObj(createdProject);
    }

    @Override
    public Project findOneById(Long id) {
        var project = this.projectRepository.getReferenceById(id);
        return this.projectEntityMapper.toDomainObj(project);
    }
    
}

package com.api_point_manager.api.infra.gateways;

import java.util.List;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;
import com.api_point_manager.api.infra.controllers.dtos.project.ReadProjectDto;
import com.api_point_manager.api.infra.mappers.ProjectEntityMapper;
import com.api_point_manager.api.infra.persistence.entities.Project;
import com.api_point_manager.api.infra.persistence.repositories.ProjectRepository;

public class ProjectRepositoryGateway implements ProjectGateway{

    private final ProjectRepository projectRepository;
    private final ProjectEntityMapper projectEntityMapper;

    public ProjectRepositoryGateway(ProjectRepository projectRepository, ProjectEntityMapper projectEntityMapper){
        this.projectRepository = projectRepository;
        this.projectEntityMapper = projectEntityMapper;
    }

    @Override
    public List<ReadProjectDto> listProjects() {
        var projects = this.projectRepository.findAll().stream().map(project -> {
            return this.projectEntityMapper.toDto(project);
        }).toList();
        return projects;
    }

    @Override
    public ReadProjectDto createProject(CreateProjectDto data) {
        Project project = this.projectEntityMapper.toEntity(data);
        Project createdProject = this.projectRepository.save(project);
        return this.projectEntityMapper.toDto(createdProject);
    }
    
}

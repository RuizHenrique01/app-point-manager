package com.api_point_manager.api.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.project.CreateProject;
import com.api_point_manager.api.application.usecases.project.DeleteProject;
import com.api_point_manager.api.application.usecases.project.FindProjectById;
import com.api_point_manager.api.application.usecases.project.GetAllProjects;
import com.api_point_manager.api.infra.controllers.mappers.ProjectDtoMapper;
import com.api_point_manager.api.infra.gateways.ProjectRepositoryGateway;
import com.api_point_manager.api.infra.mappers.ProjectEntityMapper;
import com.api_point_manager.api.infra.persistence.repositories.ProjectRepository;

@Configuration
public class ProjectConfig {
    
    @Bean
    GetAllProjects getAllProjectsCase(ProjectGateway projectGateway){
        return new GetAllProjects(projectGateway);
    }

    @Bean
    CreateProject createProjectCase(ProjectGateway projectGateway){
        return new CreateProject(projectGateway);
    }

    @Bean
    FindProjectById findProjectByIdCase(ProjectGateway projectGateway){
        return new FindProjectById(projectGateway);
    }

    @Bean
    DeleteProject deleteProjectCase(ProjectGateway projectGateway){
        return new DeleteProject(projectGateway);
    }

    @Bean
    ProjectGateway projectGateway(ProjectRepository projectRepository, ProjectEntityMapper projectEntityMapper){
        return new ProjectRepositoryGateway(projectRepository, projectEntityMapper);
    }

    @Bean
    ProjectEntityMapper projectEntityMapper(){
        return new ProjectEntityMapper();
    }

    @Bean
    ProjectDtoMapper projectDtoMapper(){
        return new ProjectDtoMapper();
    }
}

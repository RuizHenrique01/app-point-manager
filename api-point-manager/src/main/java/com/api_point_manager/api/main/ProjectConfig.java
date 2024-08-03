package com.api_point_manager.api.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api_point_manager.api.application.gateways.ProjectGateway;
import com.api_point_manager.api.application.usecases.project.GetAllProjects;
import com.api_point_manager.api.infra.gateways.ProjectRepositoryGateway;
import com.api_point_manager.api.infra.persistence.repositories.ProjectRepository;

@Configuration
public class ProjectConfig {
    
    @Bean
    GetAllProjects getAllProjectsCase(ProjectGateway projectGateway){
        return new GetAllProjects(projectGateway);
    }

    @Bean
    ProjectGateway projectGateway(ProjectRepository projectRepository){
        return new ProjectRepositoryGateway(projectRepository);
    }
}

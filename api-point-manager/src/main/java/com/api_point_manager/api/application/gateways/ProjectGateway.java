package com.api_point_manager.api.application.gateways;

import java.util.List;

import com.api_point_manager.api.domain.entities.Project;

public interface ProjectGateway {
    List<Project> listProjects();
    Project createProject(Project data);
    Project findOneById(Long id);
    Project updateProject(Project data);
    void deleteProject(Long id);
}

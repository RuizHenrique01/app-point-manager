package com.api_point_manager.api.application.gateways;

import java.util.List;

import com.api_point_manager.api.infra.persistence.entities.Project;

public interface ProjectGateway {
    List<Project> listProjects();
}

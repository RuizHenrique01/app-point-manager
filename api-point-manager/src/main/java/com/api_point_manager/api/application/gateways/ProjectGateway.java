package com.api_point_manager.api.application.gateways;

import java.util.List;

import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;
import com.api_point_manager.api.infra.controllers.dtos.project.ReadProjectDto;

public interface ProjectGateway {
    List<ReadProjectDto> listProjects();
    ReadProjectDto createProject(CreateProjectDto data);
}

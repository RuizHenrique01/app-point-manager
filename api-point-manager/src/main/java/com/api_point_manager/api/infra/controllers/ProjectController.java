package com.api_point_manager.api.infra.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_point_manager.api.application.usecases.project.CreateProject;
import com.api_point_manager.api.application.usecases.project.GetAllProjects;
import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("project")
public class ProjectController {
    private final GetAllProjects getAllProjectsUseCase;
    private final CreateProject createProjectUseCase;


    public ProjectController(GetAllProjects getAllProjects, CreateProject createProjectUseCase){
        this.getAllProjectsUseCase = getAllProjects;
        this.createProjectUseCase = createProjectUseCase;
    }

    @GetMapping()
    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.getAllProjectsUseCase.execute());
    }

    @PostMapping()
    @Transactional
    public ResponseEntity postMethodName(@RequestBody @Valid CreateProjectDto data) {
        var project = this.createProjectUseCase.execute(data);
        return ResponseEntity.ok(project);
    }
    
}

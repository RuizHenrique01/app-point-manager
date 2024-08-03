package com.api_point_manager.api.infra.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api_point_manager.api.application.usecases.project.CreateProject;
import com.api_point_manager.api.application.usecases.project.FindProjectById;
import com.api_point_manager.api.application.usecases.project.GetAllProjects;
import com.api_point_manager.api.infra.controllers.dtos.project.CreateProjectDto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("project")
public class ProjectController {
    private final GetAllProjects getAllProjectsUseCase;
    private final CreateProject createProjectUseCase;
    private final FindProjectById findProjectByIdUseCase;


    public ProjectController(
        GetAllProjects getAllProjects, 
        CreateProject createProjectUseCase, 
        FindProjectById findProjectByIdUseCase){
        this.getAllProjectsUseCase = getAllProjects;
        this.createProjectUseCase = createProjectUseCase;
        this.findProjectByIdUseCase = findProjectByIdUseCase;
    }

    @GetMapping()
    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.getAllProjectsUseCase.execute());
    }

    @PostMapping()
    @Transactional
    public ResponseEntity postMethodName(@RequestBody @Valid CreateProjectDto data, UriComponentsBuilder uriBuilder) {
        var project = this.createProjectUseCase.execute(data);
        var uri = uriBuilder.path("/project/{id}").buildAndExpand(project.id()).toUri();
        return ResponseEntity.created(uri).body(project);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(this.findProjectByIdUseCase.execute(id));
    }
}

package com.api_point_manager.api.infra.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_point_manager.api.application.usecases.project.GetAllProjects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("project")
public class ProjectController {
    private final GetAllProjects getAllProjectsUseCase;


    public ProjectController(GetAllProjects getAllProjects){
        this.getAllProjectsUseCase = getAllProjects;
    }

    @GetMapping()
    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.getAllProjectsUseCase.execute());
    }
}

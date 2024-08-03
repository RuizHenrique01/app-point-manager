package com.api_point_manager.api.infra.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_point_manager.api.infra.persistence.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}

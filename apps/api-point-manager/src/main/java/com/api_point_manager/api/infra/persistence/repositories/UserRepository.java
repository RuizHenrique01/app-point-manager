package com.api_point_manager.api.infra.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.api_point_manager.api.infra.persistence.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserDetails findByEmail(String email);
} 

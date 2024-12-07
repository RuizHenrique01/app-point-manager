package com.api_point_manager.api.application.gateways;

import com.api_point_manager.api.domain.entities.User;

public interface UserGateway {
    String login(User data);
    User createUser(User data);
    User updateUser(User data);
    User findOneById(Long id);
    void deleteUser(Long id);
} 

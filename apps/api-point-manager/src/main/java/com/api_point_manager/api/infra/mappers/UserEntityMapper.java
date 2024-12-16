package com.api_point_manager.api.infra.mappers;

import com.api_point_manager.api.domain.entities.User;
import com.api_point_manager.api.infra.persistence.entities.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User data){
        return new UserEntity(data.name(), data.username(), data.email(), data.password());
    }

    public User toDomainObj(UserEntity data){
        return new User(
            data.getId(), 
            data.getName(), 
            data.getUsernameField(),
            data.getEmail(),
            data.getPassword(),
            data.getCreatedAt(), 
            data.getUpdatedAt());
    }
}

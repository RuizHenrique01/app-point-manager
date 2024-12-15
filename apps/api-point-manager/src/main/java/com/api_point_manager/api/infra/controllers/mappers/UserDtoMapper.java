package com.api_point_manager.api.infra.controllers.mappers;

import com.api_point_manager.api.domain.entities.User;
import com.api_point_manager.api.infra.controllers.dtos.user.CreateUserDto;
import com.api_point_manager.api.infra.controllers.dtos.user.LoginUserDto;
import com.api_point_manager.api.infra.controllers.dtos.user.ReadUserDto;

public class UserDtoMapper {
    public User toUser(CreateUserDto data) {
        return new User(null, data.name(), data.username(), data.email(), data.password(), null, null);
    }

    public User toUser(LoginUserDto data) {
        return new User(null, null, null, data.email(), data.password(), null, null);
    }

    public ReadUserDto toReadUserDto(User data){
        return new ReadUserDto(data.id(), data.name(), data.username(), data.email());
    }
}

package com.api_point_manager.api.application.usecases.user;

import com.api_point_manager.api.application.gateways.UserGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.User;

public class UpdateUser extends AbstractUseCase<User, User> {
    private final UserGateway userGateway;

    public UpdateUser(UserGateway userGateway){
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User data) {
        return this.userGateway.updateUser(data);
    }
}

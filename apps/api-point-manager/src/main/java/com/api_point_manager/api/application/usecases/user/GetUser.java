package com.api_point_manager.api.application.usecases.user;

import com.api_point_manager.api.application.gateways.UserGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.User;

public class GetUser extends AbstractUseCase<Long, User> {
    private final UserGateway userGateway;

    public GetUser(UserGateway userGateway){
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id) {
        return this.userGateway.findOneById(id);
    }
}

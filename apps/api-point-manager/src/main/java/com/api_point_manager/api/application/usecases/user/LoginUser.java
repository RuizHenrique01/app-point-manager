package com.api_point_manager.api.application.usecases.user;

import com.api_point_manager.api.application.gateways.UserGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;
import com.api_point_manager.api.domain.entities.User;

public class LoginUser extends AbstractUseCase<User, String> {
    private final UserGateway userGateway;

    public LoginUser(UserGateway userGateway){
        this.userGateway = userGateway;
    }

    @Override
    public String execute(User data) {
        return this.userGateway.login(data);
    }
}

package com.api_point_manager.api.application.usecases.user;

import com.api_point_manager.api.application.gateways.UserGateway;
import com.api_point_manager.api.application.usecases.AbstractUseCase;

public class DeleteUser extends AbstractUseCase<Long, Void> {
    private final UserGateway userGateway;

    public DeleteUser(UserGateway userGateway){
        this.userGateway = userGateway;
    }

    @Override
    public Void execute(Long id) {
        this.userGateway.deleteUser(id);
        return null;
    }
}

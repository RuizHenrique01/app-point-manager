package com.api_point_manager.api.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import com.api_point_manager.api.application.gateways.UserGateway;
import com.api_point_manager.api.application.usecases.user.CreateUser;
import com.api_point_manager.api.application.usecases.user.GetUser;
import com.api_point_manager.api.application.usecases.user.LoginUser;
import com.api_point_manager.api.application.usecases.user.UpdateUser;
import com.api_point_manager.api.infra.configs.security.TokenService;
import com.api_point_manager.api.infra.controllers.mappers.UserDtoMapper;
import com.api_point_manager.api.infra.gateways.UserRepositoryGateway;
import com.api_point_manager.api.infra.mappers.UserEntityMapper;
import com.api_point_manager.api.infra.persistence.repositories.UserRepository;

@Configuration
public class UserConfig {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Bean
    CreateUser createUserCase(UserGateway userGateway) {
        return new CreateUser(userGateway);
    }

    @Bean
    UpdateUser updateUserCase(UserGateway userGateway) {
        return new UpdateUser(userGateway);
    }

    @Bean
    GetUser getUserCase(UserGateway userGateway) {
        return new GetUser(userGateway);
    }

    @Bean
    LoginUser loginUserCase(UserGateway userGateway) {
        return new LoginUser(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper, authenticationManager, tokenService);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDtoMapper userDtoMapper() {
        return new UserDtoMapper();
    }
}

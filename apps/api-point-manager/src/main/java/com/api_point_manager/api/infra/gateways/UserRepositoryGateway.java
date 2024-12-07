package com.api_point_manager.api.infra.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api_point_manager.api.application.gateways.UserGateway;
import com.api_point_manager.api.domain.entities.User;
import com.api_point_manager.api.infra.configs.security.TokenService;
import com.api_point_manager.api.infra.mappers.UserEntityMapper;
import com.api_point_manager.api.infra.persistence.entities.UserEntity;
import com.api_point_manager.api.infra.persistence.repositories.UserRepository;

public class UserRepositoryGateway implements UserGateway {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper, AuthenticationManager authenticationManager, TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public String login(User data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(authToken);
        var tokenJWT = tokenService.generateToken((UserEntity) auth.getPrincipal());
        return tokenJWT;
    }

    @Override
    public User createUser(User data) {
        User userWithPasswordEncrypted = data.updatePassword(new BCryptPasswordEncoder().encode(data.password()));
        UserEntity user = this.userEntityMapper.toEntity(userWithPasswordEncrypted);
        UserEntity createdUser = this.userRepository.save(user);
        return this.userEntityMapper.toDomainObj(createdUser);
    }

    @Override
    public User updateUser(User data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public User findOneById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOneById'");
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
}

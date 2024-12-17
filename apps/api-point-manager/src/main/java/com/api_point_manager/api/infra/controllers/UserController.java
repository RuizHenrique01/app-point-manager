package com.api_point_manager.api.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_point_manager.api.application.usecases.user.CreateUser;
import com.api_point_manager.api.application.usecases.user.DeleteUser;
import com.api_point_manager.api.application.usecases.user.GetUser;
import com.api_point_manager.api.application.usecases.user.LoginUser;
import com.api_point_manager.api.application.usecases.user.UpdateUser;
import com.api_point_manager.api.domain.common.DataJWT;
import com.api_point_manager.api.domain.entities.User;
import com.api_point_manager.api.infra.controllers.dtos.user.CreateUserDto;
import com.api_point_manager.api.infra.controllers.dtos.user.LoginUserDto;
import com.api_point_manager.api.infra.controllers.dtos.user.UpdateUserDto;
import com.api_point_manager.api.infra.controllers.mappers.UserDtoMapper;
import com.api_point_manager.api.infra.mappers.UserEntityMapper;
import com.api_point_manager.api.infra.persistence.entities.UserEntity;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    private final CreateUser createUserUseCase;
    private final GetUser getUserUseCase;
    private final LoginUser loginUserUseCase;
    private final UpdateUser updateUserUseCase;
    private final DeleteUser deleteUserUseCase;
    private final UserDtoMapper userDtoMapper;
    private final UserEntityMapper userEntityMapper;

    public UserController(
        CreateUser createUserUseCase, 
        UserDtoMapper userDtoMapper, 
        LoginUser loginUserUseCase,
        GetUser getUserUseCase,
        UserEntityMapper userEntityMapper,
        UpdateUser updateUserUseCase,
        DeleteUser deleteUserUseCase
    ){
        this.createUserUseCase = createUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.userDtoMapper = userDtoMapper;
        this.getUserUseCase = getUserUseCase;
        this.userEntityMapper = userEntityMapper;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid CreateUserDto data) {
        var createdUser = this.createUserUseCase.execute(this.userDtoMapper.toUser(data));
        return ResponseEntity.ok(createdUser);
    }


    @PostMapping("/signin")
    @Transactional
    public ResponseEntity loginUser(@RequestBody @Valid LoginUserDto data) {
        var loginToken = this.loginUserUseCase.execute(this.userDtoMapper.toUser(data));
        return ResponseEntity.ok(new DataJWT(loginToken));
    }

    @GetMapping("/")
    public ResponseEntity getUser(Authentication authentication){
        User user = this.userEntityMapper.toDomainObj((UserEntity) authentication.getPrincipal());

        var findUser = this.getUserUseCase.execute(user.id());

        return ResponseEntity.ok(this.userDtoMapper.toReadUserDto(findUser));
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity updateUser(@RequestBody @Valid UpdateUserDto data, Authentication authentication){
        User user = this.userEntityMapper.toDomainObj((UserEntity) authentication.getPrincipal());

        this.updateUserUseCase.execute(this.userDtoMapper.toUser(user.id(), data));

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/")
    @Transactional
    public ResponseEntity deleteUser(Authentication authentication){
        User user = this.userEntityMapper.toDomainObj((UserEntity) authentication.getPrincipal());

        this.deleteUserUseCase.execute(user.id());

        return ResponseEntity.noContent().build();
    }
}

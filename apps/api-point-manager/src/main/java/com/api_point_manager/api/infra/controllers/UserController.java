package com.api_point_manager.api.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_point_manager.api.application.usecases.user.CreateUser;
import com.api_point_manager.api.application.usecases.user.LoginUser;
import com.api_point_manager.api.domain.common.DataJWT;
import com.api_point_manager.api.infra.controllers.dtos.user.CreateUserDto;
import com.api_point_manager.api.infra.controllers.dtos.user.LoginUserDto;
import com.api_point_manager.api.infra.controllers.mappers.UserDtoMapper;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    private final CreateUser createUserUseCase;
    private final LoginUser loginUserUseCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(
        CreateUser createUserUseCase, 
        UserDtoMapper userDtoMapper, 
        LoginUser loginUserUseCase
    ){
        this.createUserUseCase = createUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.userDtoMapper = userDtoMapper;
      
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
}

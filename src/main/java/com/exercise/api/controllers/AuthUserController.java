package com.exercise.api.controllers;

import com.exercise.api.dtos.AuthUserDto;
import com.exercise.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class AuthUserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody AuthUserDto authUserDto) {
        return ResponseEntity.ok().build();
    }

}

package com.exercise.api.controllers;

import com.exercise.api.entities.dtos.AuthUser;
import com.exercise.api.entities.dtos.UserDto;
import com.exercise.api.entities.User;
import com.exercise.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class AuthUserController {

    final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AuthUser authUser) {
        try {
            UserDto userDto = userService.loginUser(authUser);
            return new ResponseEntity<UserDto>(userDto, HttpStatus.ACCEPTED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            UserDto userDto = userService.registerUser(user);
            return new ResponseEntity<UserDto>(userDto, HttpStatus.ACCEPTED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

package com.exercise.api.services;

import com.exercise.api.entities.dtos.*;
import com.exercise.api.entities.User;

public interface IUserService {

    public UserDto registerUser(User user);
    public UserDto loginUser(AuthUser authUser);
    public User getUserById(Long id);
    public UserDto convertUserToDto(User user);

}

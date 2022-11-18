package com.exercise.api.services;

import com.exercise.api.entities.dtos.*;
import com.exercise.api.entities.User;
import com.exercise.api.entities.dtos.AuthUser;
import com.exercise.api.entities.dtos.UserDto;
import com.exercise.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public UserDto registerUser(User user) {

        User userFound = userRepository.findByUsername(user.getUsername()).orElse(null);

        if (userFound != null) throw new IllegalStateException("Username already exists");
        System.out.println(">>> Registering user: " + user.toString());

        User userSaved = userRepository.save(user);
        return convertUserToDto(userSaved);
    }

    public UserDto loginUser(AuthUser authUser) {
        User userFound = userRepository.findByUsername(authUser.getUsername()).orElse(null);
        if (userFound == null) throw new IllegalStateException("Username not found");
        if (!userFound.getUsername().equals(authUser.getUsername())) throw new IllegalStateException("User not found");

        return convertUserToDto(userFound);
    }

    public User getUserById(Long id) {
        User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null) throw new IllegalStateException("User not found");
        return userFound;
    }

    public UserDto convertUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }
}

package com.exercise.api.services;

import com.exercise.api.dtos.AuthUser;
import com.exercise.api.dtos.UserDto;
import com.exercise.api.entities.User;
import com.exercise.api.repositories.IUserAddressRepository;
import com.exercise.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDto registerUser(User user) {

        User userFound = userRepository.findUserByUsername(user.getUsername()).orElse(null);
        if(userFound == null){
        throw new IllegalStateException("invalid username");
        }
        if (userFound.getUsername().equals(user.getUsername())){
            throw new IllegalStateException("invalid username");
        }
        User userSaved = userRepository.save(user);
        return convertUserToDto(userSaved);
    }

    @Override
    public UserDto loginUser(AuthUser authUser) {
        User userFound = userRepository.findUserByUsername(authUser.getUsername()).orElse(null);
        if(userFound == null){
            throw new IllegalStateException("");
        }
        if (!authUser.getUsername().equals(userFound.getUsername())){

            throw new IllegalStateException("invalid username");
        }
        if (!authUser.getPassword().equals(userFound.getPassword())){

            throw new IllegalStateException("invalid Password");
        }

        return convertUserToDto(userFound);


    }

    @Override
    public User getUserById(Long id) {
       User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null){
            throw new IllegalStateException("invalid ID");
        }
        return userFound;
    }

    @Override
    public UserDto convertUserToDto(User user) {//llega user convierte la var user a DTO
        UserDto userDto = new UserDto();//constructor o instanciar a nuevo dto
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }


}

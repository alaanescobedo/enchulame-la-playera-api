package com.exercise.api.services;

import com.exercise.api.entities.User;
import com.exercise.api.entities.UserAddress;
import com.exercise.api.repositories.IUserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    @Autowired
    private IUserAddressRepository repository;

    @Autowired
    private IUserService userService;

    public UserAddress addUserAddress(Long id, UserAddress address) {
        try {
            User user = userService.getUserById(id);
            address.setUser(user);

            return repository.save(address);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

}

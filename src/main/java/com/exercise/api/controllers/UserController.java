package com.exercise.api.controllers;

import com.exercise.api.entities.UserAddress;
import com.exercise.api.repositories.IUserAddressRepository;
import com.exercise.api.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{id}/address")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class UserController {


    @Autowired
    private UserAddressService userAddressService;

    @PostMapping
    public void addUserAddress(@PathVariable Long id, @RequestBody UserAddress userAddress) {
        userAddressService.addUserAddress(id, userAddress);
    }
}

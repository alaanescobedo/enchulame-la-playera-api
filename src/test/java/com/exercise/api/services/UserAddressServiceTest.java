package com.exercise.api.services;

import com.exercise.api.entities.User;
import com.exercise.api.entities.UserAddress;
import com.exercise.api.repositories.IUserAddressRepository;
import com.exercise.api.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserAddressServiceTest {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserAddressRepository userAddressRepository;

    @Autowired
    private UserAddressService service;

    private User user;
    private UserAddress address;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("test_user");
        user.setEmail("test@user.com");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPassword("test_password");
        user.setPhoneNumber("1234567890");

        User userSaved = userRepository.save(user);

        address = new UserAddress();
        address.setId(1L);
        address.setUser(userSaved);
        address.setAddress1("123 Main St");
        address.setCity("Tagamandapio");
        address.setState("Michoacán");
        address.setCountry("México");
        address.setZipCode("12345");
        address.setUser(userSaved);

        userAddressRepository.save(address);
    }

    @Test
    void addUserAddress() {
        UserAddress address = new UserAddress();
        address.setId(2L);
        address.setAddress1("Test address");
        address.setCity("Cd. Peluche");
        address.setState("Michoacán");
        address.setCountry("México");
        address.setZipCode("12345");
        address.setUser(userRepository.findById(1L).get());

        UserAddress addressSaved = service.addUserAddress(user.getId(),address);

        assertNotNull(addressSaved);
        assertEquals(addressSaved.getId(), address.getId());
        assertEquals(addressSaved.getCity(), address.getCity());
        assertEquals(addressSaved.getState(), address.getState());
        assertEquals(addressSaved.getCountry(), address.getCountry());
        assertEquals(addressSaved.getZipCode(), address.getZipCode());
        assertEquals(addressSaved.getUser().getId(), address.getUser().getId());
    }
}
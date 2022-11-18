package com.exercise.api.services;

import com.exercise.api.dtos.AuthUser;
import com.exercise.api.dtos.UserDto;
import com.exercise.api.entities.User;
import com.exercise.api.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private UserService service;

    private User user;

    @BeforeEach
    void setUp() {

        user = new User();
        user.setId(1L);
        user.setUsername("Test");
        user.setPassword("superpassword");
        user.setEmail("test@admin.com");
        user.setFirstName("Test");
        user.setLastName("Admin");
        user.setPhoneNumber("1234567890");

        repository.save(user);
    }

    @Test
    void registerUser() {
        User user = new User();
        user.setId(2L);
        user.setUsername("Test2");
        user.setPassword("superpassword");
        user.setEmail("test2@user.com");
        user.setFirstName("Test2");
        user.setLastName("User");
        user.setPhoneNumber("1234567890");

        UserDto userSaved = service.registerUser(user);

        assertNotNull(userSaved);
        assertEquals(userSaved.getUsername(), user.getUsername());
        assertEquals(userSaved.getEmail(), user.getEmail());
        assertEquals(userSaved.getFirstName(), user.getFirstName());
        assertEquals(userSaved.getLastName(), user.getLastName());
        assertEquals(userSaved.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(userSaved.getId(), user.getId());
    }

    @Test
    void loginUser() {
        AuthUser authUser = new AuthUser();
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());

        UserDto userFound = service.loginUser(authUser);

        assertNotNull(userFound);
        assertEquals(userFound.getUsername(), user.getUsername());
        assertEquals(userFound.getEmail(), user.getEmail());
        assertEquals(userFound.getFirstName(), user.getFirstName());
        assertEquals(userFound.getLastName(), user.getLastName());
        assertEquals(userFound.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(userFound.getId(), user.getId());
    }

    @Test
    void convertUserToDto() {
        UserDto userDto = service.convertUserToDto(user);

        assertNotNull(userDto);
        assertEquals(userDto.getUsername(), user.getUsername());
        assertEquals(userDto.getEmail(), user.getEmail());
        assertEquals(userDto.getFirstName(), user.getFirstName());
        assertEquals(userDto.getLastName(), user.getLastName());
        assertEquals(userDto.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(userDto.getId(), user.getId());
    }
}
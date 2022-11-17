package com.exercise.api.entities.abstract_class;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public class UserAbstract {

    public static final int FIRST_NAME_MAX_LENGTH = 150;
    public static final int LASTNAME_MAX_LENGTH = 150;
    public static final int AVATAR_MAX_LENGTH = 150;
    public static final int EMAIL_MAX_LENGTH = 150;
    public static final int PASSWORD_MAX_LENGTH = 150;
    public static final int ADDRESS_MAX_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name", unique = true, nullable = false)
    private String username;
    @NotNull
    @Column(name = "email", unique = true, nullable = false, length = EMAIL_MAX_LENGTH)
    private String email;
    @NotNull
    @Column(name = "first_name", nullable = false, length=FIRST_NAME_MAX_LENGTH)
    private String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false,length=LASTNAME_MAX_LENGTH)
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "img",length=AVATAR_MAX_LENGTH)
    private String img;
}

package com.exercise.api.entities.abstract_class;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class UserAbstract {

    public static final int FIRST_NAME_MAX_LENGTH = 150;
    public static final int LASTNAME_MAX_LENGTH = 150;
    public static final int EMAIL_MAX_LENGTH = 150;
    public static final int PASSWORD_MAX_LENGTH = 150;
    public static final int ADDRESS_MAX_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
    @NotNull
    @Column(name = "name", unique = true, nullable = false)
    protected String username;
    @NotNull
    @Column(name = "email", unique = true, nullable = false, length = EMAIL_MAX_LENGTH)
    protected String email;
    @NotNull
    @Column(name = "first_name", nullable = false, length=FIRST_NAME_MAX_LENGTH)
    protected String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false,length=LASTNAME_MAX_LENGTH)
    protected String lastName;
    @Column(name = "phone_number", nullable = false)
    protected String phoneNumber;
}

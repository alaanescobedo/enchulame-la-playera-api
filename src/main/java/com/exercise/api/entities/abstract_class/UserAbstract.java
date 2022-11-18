package com.exercise.api.entities.abstract_class;

import lombok.Data;
import org.intellij.lang.annotations.Identifier;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class UserAbstract {

    public static final int FIRST_NAME_MAX_LENGTH = 150;
    public static final int LASTNAME_MAX_LENGTH = 150;
    public static final int EMAIL_MAX_LENGTH = 150;
    public static final int PASSWORD_MAX_LENGTH = 150;
    public static final int ADDRESS_MAX_LENGTH = 200;


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    protected Long id;
    @Column(name="username",unique = true, nullable = false)
    protected String username;
    @Column(name="email",unique = true,nullable = false,length = EMAIL_MAX_LENGTH)
    protected String email;
    @Column(name="first_name",nullable=false,length = FIRST_NAME_MAX_LENGTH)
    protected String firstName;
    @Column(name="last_name",nullable=false,length = LASTNAME_MAX_LENGTH)
    protected String lastName;
    @Column(name="phone_number",nullable=false)
    protected String phoneNumber;




}

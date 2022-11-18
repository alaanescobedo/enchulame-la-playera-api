package com.exercise.api.entities;

import com.exercise.api.entities.abstract_class.UserAbstract;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends UserAbstract {

    @Column(name = "password",nullable = false,length = PASSWORD_MAX_LENGTH)
    private String password;


}

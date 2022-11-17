package com.exercise.api.entities;

import com.exercise.api.entities.abstract_class.UserAbstract;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data

@Entity
@Table(name = "users")
public class User extends UserAbstract {

    @Column(name = "password", nullable = false, length = PASSWORD_MAX_LENGTH)
    private String password;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;
}

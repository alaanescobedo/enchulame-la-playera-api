package com.exercise.api.entities;

import com.exercise.api.entities.abstract_class.UserAbstract;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "users")
public class User extends UserAbstract {

    @NotNull
    @Column(name = "password", nullable = false, length = PASSWORD_MAX_LENGTH)
    private String password;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;
}

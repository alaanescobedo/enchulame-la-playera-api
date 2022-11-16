package com.exercise.api.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "colors")
public class Color extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}

package com.exercise.api.entities;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}

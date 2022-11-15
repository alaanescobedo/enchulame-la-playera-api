package com.exercise.api.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sizes")
public class Size extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}

package com.exercise.api.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)

@Data
@Table(name = "sizes")
public class Size extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}

package com.exercise.api.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "products_categories")
public class ProductCategory extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}

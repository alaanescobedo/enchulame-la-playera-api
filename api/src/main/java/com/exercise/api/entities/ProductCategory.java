package com.exercise.api.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "products_categories")
public class ProductCategory extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}

package com.exercise.api.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image_url", nullable = false)
    private String image;

    @Column(name = "stock", nullable = false, insertable = false, columnDefinition = "int default 1")
    private Integer stock;

    @ManyToOne(targetEntity = ProductCategory.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @ManyToMany(targetEntity = Size.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_sizes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id")
    )
    private List<Size> sizes;

    @ManyToMany(targetEntity = Color.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_colors",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<Color> colors;
}

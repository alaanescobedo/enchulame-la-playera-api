package com.exercise.api.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "description_short", nullable = false)
    private String descriptionShort;

    @Column(name = "image_url", nullable = false)
    private String image;

    @Column(name = "stock", nullable = false, insertable = false, columnDefinition = "int default 1")
    private Integer stock;

    @ManyToOne(targetEntity = ProductCategory.class)
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @ManyToMany(targetEntity = Size.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_sizes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id")
    )
    private List<Size> sizes;

    @ManyToMany(targetEntity = Color.class,fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_colors",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<Color> colors;

}

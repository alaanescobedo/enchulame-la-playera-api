package com.exercise.api.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateProductDto {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    private double price;

    @NotNull(message = "Category is required")
    private Long category;

    @NotNull(message = "IMG is required")
    private String img;

    @NotNull(message = "Stock is required")
    private int stock;

    @NotNull(message = "Sizes are required")
    private Long sizes;

    @NotNull(message = "Colors are required")
    private Long colors;


}

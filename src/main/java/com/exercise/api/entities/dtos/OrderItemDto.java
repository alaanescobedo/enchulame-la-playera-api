package com.exercise.api.entities.dtos;

import lombok.Data;

@Data

public class OrderItemDto {

    private Long productId;
    private Long orderDetailId;
    private Integer quantity;
}

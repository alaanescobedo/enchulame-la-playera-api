package com.exercise.api.controllers;

import com.exercise.api.entities.OrderDetail;
import com.exercise.api.entities.OrderItem;
import com.exercise.api.entities.Product;
import com.exercise.api.entities.dtos.OrderItemDto;
import com.exercise.api.repositories.IOrderDetailsRepository;
import com.exercise.api.repositories.IOrderItemsRepository;
import com.exercise.api.repositories.IProductRepository;
import com.exercise.api.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")

public class OrderController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrderItems(OrderItemDto orderItemDto) {
        try {

            return ResponseEntity.ok().body("Order Item created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating order item");
        }
    }

}

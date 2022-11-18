package com.exercise.api.services;

import com.exercise.api.entities.OrderDetail;
import com.exercise.api.entities.OrderItem;
import com.exercise.api.entities.Product;
import com.exercise.api.entities.dtos.OrderItemDto;
import com.exercise.api.repositories.IOrderDetailsRepository;
import com.exercise.api.repositories.IOrderItemsRepository;
import com.exercise.api.repositories.IProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private IOrderItemsRepository orderItemsRepository;

    @Autowired
    private IOrderDetailsRepository orderDetailsRepository;

    @Autowired
    private IProductRepository productRepository;

    public void createOrderItem(OrderItemDto orderItemDto) {
        OrderDetail orderDetail = orderDetailsRepository.findById(orderItemDto.getOrderDetailId()).orElse(null);
        if(orderDetail == null) return;

        Product product = productRepository.findById(orderItemDto.getProductId()).orElse(null);
        if(product == null) throw new IllegalStateException("Product not found");

        OrderItem orderItem = new OrderItem();

        orderItem.setOrderDetail(orderDetail);
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setProduct(product);
        orderItem.setSubtotal(orderItem.calculateSubtotal());

        orderItemsRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItemsByUserId(Long userId) {
//        List<OrderItem> orderItems = (List<OrderItem>) orderItemsRepository.findAllByUserId(userId).orElse(null);
//        if(orderItems == null) throw new IllegalStateException("Order items not found");
//        return orderItems;
        return null;
    }
    public OrderItem updateQuantity(OrderItem oderItem, Integer quantity) {
        OrderItem orderItem = orderItemsRepository.findById(oderItem.getId()).orElse(null);
        if(orderItem == null) {
            throw new IllegalStateException("Order Item not found");
        }

        orderItem.setQuantity(oderItem.getQuantity() + quantity);
        orderItem.setSubtotal(orderItem.calculateSubtotal());

        return orderItemsRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
//        boolean exists = orderItemsRepository.existsById(id);
//        if(!exists) throw new IllegalStateException("Order Item with id " + id + " does not exists");
//        orderItemsRepository.deleteById(id);
    }

    public void deleteMultipleOrderItems(Long id) {
//        orderItemsRepository.deleteAllByUserId(id);
    }
}

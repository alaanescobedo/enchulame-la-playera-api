package com.exercise.api.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "order_details")
public class OrderDetail extends BaseEntity {

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orderDetail")
    private List<OrderItem> orderItems;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "status", nullable = false)
    private String status;

}

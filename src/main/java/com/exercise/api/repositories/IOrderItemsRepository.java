package com.exercise.api.repositories;

import com.exercise.api.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderItemsRepository extends JpaRepository<OrderItem, Long> {


}

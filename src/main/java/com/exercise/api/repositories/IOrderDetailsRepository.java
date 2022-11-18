package com.exercise.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.api.entities.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetail, Long> {

}

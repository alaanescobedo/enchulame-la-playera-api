package com.exercise.api.repositories;

import com.exercise.api.entities.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAddressRepository extends JpaRepository<UserAddress, Long> {

}

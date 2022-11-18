package com.exercise.api.repositories;

import com.exercise.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
     Optional<User> findUserByUsername(String UserName);

}

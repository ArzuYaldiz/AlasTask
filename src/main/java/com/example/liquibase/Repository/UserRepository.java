package com.example.liquibase.Repository;

import java.util.Optional;

import com.example.liquibase.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
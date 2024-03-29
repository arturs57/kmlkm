package com.example.exdemo.repo;

import com.example.exdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long > {
    List<User> findByNameContainingIgnoreCase(String name);
}

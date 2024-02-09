package com.example.exdemo.service;

import com.example.exdemo.model.User;
import com.example.exdemo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAll() { return userRepo.findAll(); }

    public void save(User user){
        user.setName(user.getName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userRepo.save(user);
    }
    public List<User> findUserByName(String name){
        return userRepo.findByNameContainingIgnoreCase(name);
    }
}

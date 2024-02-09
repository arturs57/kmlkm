package com.example.exdemo.controller;

import com.example.exdemo.model.User;
import com.example.exdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("")
    String mainPage() {
        return "index";
    }

    @GetMapping("/all")
    String findAllUser(Model model, String name) {
        if (name == null) {
            model.addAttribute("users", userService.findAll());
            return "userList";
        } else {
            model.addAttribute("users", userService.findUserByName(name));
            return "userList";
        }
    }
    @GetMapping("/form-add")
    String getAddUserForm(){
        return "add-user";
    }

    @PostMapping("/save")
    String saveUser(User user){
        userService.save(user);
        return "redirect:/all";
    }
}



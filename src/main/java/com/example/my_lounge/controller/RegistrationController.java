package com.example.my_lounge.controller;

import com.example.my_lounge.domain.User;
import com.example.my_lounge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        if (userService.loadUserByUsername(user.getUsername()) != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        userService.userAdd(user);
        return "redirect:/login";
    }
}

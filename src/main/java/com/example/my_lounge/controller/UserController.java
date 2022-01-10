package com.example.my_lounge.controller;

import com.example.my_lounge.domain.Role;
import com.example.my_lounge.domain.User;
import com.example.my_lounge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Map<String, Object> model) {
        model.put("users", userService.userList());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditor(@PathVariable User user, Map<String, Object> model) {
        model.put("user", user);
        model.put("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userUpdate(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam("userId") User user,
            @RequestParam Map<String, String> form
    ) {
        userService.userUpdate(username, password, user, form);

        return "redirect:/user";
    }
}

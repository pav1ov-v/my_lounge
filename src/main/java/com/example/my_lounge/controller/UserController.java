package com.example.my_lounge.controller;

import com.example.my_lounge.dao.UserRepository;
import com.example.my_lounge.domain.Role;
import com.example.my_lounge.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String userList(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditor(@PathVariable User user, Map<String, Object> model) {
        model.put("user", user);
        model.put("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam("userId") User user,
            @RequestParam Map<String, String> form
    ) {
        user.setUsername(username);

        user.getRoles().clear();


        Set<String> roles = new HashSet<>();
        for (Role role : Role.values()) {
            roles.add(role.toString());
        }

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

        return "redirect:/user";
    }
}

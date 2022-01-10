package com.example.my_lounge.service;

import com.example.my_lounge.dao.UserRepository;
import com.example.my_lounge.domain.Role;
import com.example.my_lounge.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userAdd(User user){
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> userList() {
        return userRepository.findAll();
    }

    public void userUpdate(String username, String password, User user, Map<String, String> form) {
        user.setUsername(username);
        user.setPassword(password);
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
    }
}

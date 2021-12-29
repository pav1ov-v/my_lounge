package com.example.my_lounge.dao;

import com.example.my_lounge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String user_name);
}

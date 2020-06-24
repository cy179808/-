package com.example.blog.dao;

import com.example.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findAllByUsernameAndPassword(String username, String password);
}

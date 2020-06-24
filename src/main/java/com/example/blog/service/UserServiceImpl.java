package com.example.blog.service;

import com.example.blog.dao.UserRepository;
import com.example.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findAllByUsernameAndPassword(username, password);
        return user;

    }
}

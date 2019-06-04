package com.sunset.service.Impl;

import com.sunset.dao.UserRepository;
import com.sunset.model.User;
import com.sunset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;
    @Override
    public User checkUser(String username, String password) {
        User user = repository.findUserByUsernameAndPassword(username, password);

        return user;
    }
}

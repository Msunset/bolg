package com.sunset.service;

import com.sunset.model.User;

public interface UserService {
    User checkUser(String username,String password);
}

package com.richard.service;

import com.richard.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    User login(User user);

    User register(User user);

    User findUserById(Integer id);

    boolean updateUser(User user);
}

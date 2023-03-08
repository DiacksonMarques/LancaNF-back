package com.lanca.api.service;

import com.lanca.api.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User insertUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}

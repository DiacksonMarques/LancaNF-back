package com.lanca.api.service.Impl;

import com.lanca.api.model.User;
import com.lanca.api.repository.UserRepository;
import com.lanca.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }
    @Override
    public User insertUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user){
        return userRepository.findById(user.getId()).
                map(client -> {
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    return userRepository.save(user);
                });
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

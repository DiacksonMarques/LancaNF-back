package com.lanca.api.controller;

import com.lanca.api.model.User;
import com.lanca.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getUserAll(){
        return userService.getAll();
    }

    @PostMapping("/api/user/")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping("/api/user/")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/api/user/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}

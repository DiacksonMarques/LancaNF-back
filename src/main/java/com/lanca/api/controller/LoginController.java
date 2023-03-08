package com.lanca.api.controller;

import com.lanca.api.domain.LoginDTO;
import com.lanca.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/api/login")
    public Object authenticateUser(@RequestBody LoginDTO loginDTO){
        return loginService.authenticateUser(loginDTO);
    }
}

package com.lanca.api.service.Impl;

import com.lanca.api.domain.LoginDTO;
import com.lanca.api.domain.UserDTO;
import com.lanca.api.model.User;
import com.lanca.api.repository.UserRepository;
import com.lanca.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity authenticateUser(LoginDTO loginDTO){
        String userNameDecode= new String(Base64.getDecoder().decode(loginDTO.getUserName()));
        String passwordDecode= new String(Base64.getDecoder().decode(loginDTO.getPassword()));

      User newUser = userRepository.findByUserNameAndPassword(userNameDecode, passwordDecode);

      if(newUser != null){
          UserDTO userDTO = new UserDTO();
          userDTO.setUser(newUser);
          return ResponseEntity.ok(userDTO);
      }

      return ResponseEntity.status(200).build();
    };
}

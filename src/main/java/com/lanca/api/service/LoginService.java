package com.lanca.api.service;

import com.lanca.api.domain.LoginDTO;

public interface LoginService {
    Object authenticateUser(LoginDTO login);
}

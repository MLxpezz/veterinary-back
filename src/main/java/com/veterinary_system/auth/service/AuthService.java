package com.veterinary_system.auth.service;

import com.veterinary_system.auth.dto.LoginDTO;

public interface AuthService {

    String loginUser(LoginDTO loginDTO);
}

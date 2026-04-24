package com.veterinary_system.auth.controller;

import com.veterinary_system.auth.dto.LoginDTO;
import com.veterinary_system.auth.service.AuthService;
import com.veterinary_system.common.dto.ApiResponse;
import com.veterinary_system.common.enums.ApiMessage;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody @Valid LoginDTO loginDTO) {

        ApiResponse<String> apiResponse = ApiResponse
                .<String>builder()
                .status(ApiMessage.SUCCESSFULLY_AUTHENTICATION.getStatus().value())
                .message(ApiMessage.SUCCESSFULLY_AUTHENTICATION.getMessage())
                .data(authService.loginUser(loginDTO))
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}

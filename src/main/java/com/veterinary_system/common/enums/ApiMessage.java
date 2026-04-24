package com.veterinary_system.common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiMessage{

    //SUCCESS MESSAGE
    SUCCESSFULLY_AUTHENTICATION("Authentication successful", HttpStatus.OK),


    //ERROR MESSAGE
    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
    AUTHENTICATION_FAILED("authentication is failed", HttpStatus.UNAUTHORIZED),
    BAD_CREDENTIALS("Bad credentials", HttpStatus.UNAUTHORIZED);

    private final String message;
    private final HttpStatus status;

    ApiMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}

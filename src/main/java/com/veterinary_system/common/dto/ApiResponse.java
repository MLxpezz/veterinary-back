package com.veterinary_system.common.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;
}

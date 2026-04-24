package com.veterinary_system.auth.dto;

import lombok.Builder;

@Builder
public record LoginDTO(
        String email,
        String password
) {
}

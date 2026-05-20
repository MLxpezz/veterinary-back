package com.veterinary_system.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginDTO(
        @NotBlank(message = "El email es requerido")
        @Email(message = "El email no es valido")
        String email,
        @NotBlank(message = "La contraseña es requerida")
        String password
) {
}

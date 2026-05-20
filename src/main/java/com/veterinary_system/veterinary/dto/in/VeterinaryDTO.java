package com.veterinary_system.veterinary.dto.in;

import lombok.Builder;

@Builder
public record VeterinaryDTO(
        String name,
        String description,
        String address,
        String phone,
        String whatsapp
) {
}

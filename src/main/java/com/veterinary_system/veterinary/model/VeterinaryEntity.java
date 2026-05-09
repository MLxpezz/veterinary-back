package com.veterinary_system.veterinary.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Veterinary")
public class VeterinaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String address;

    private String phone;

    private String whatsapp;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean isActive;

    private String plan;
}

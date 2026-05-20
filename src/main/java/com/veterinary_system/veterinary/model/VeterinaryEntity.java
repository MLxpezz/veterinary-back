package com.veterinary_system.veterinary.model;

import com.veterinary_system.services.model.ServicesEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"services"})
@EqualsAndHashCode(exclude = {"services"})
@Getter
@Setter
@Entity
@Table(name = "Veterinary")
public class VeterinaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String whatsapp;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(nullable = false)
    private String plan;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "veterinary_services",
            joinColumns = @JoinColumn(name = "veterinary_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<ServicesEntity> services;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now();
        isActive = true;
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

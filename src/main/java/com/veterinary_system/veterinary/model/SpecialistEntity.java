package com.veterinary_system.veterinary.model;


import com.veterinary_system.services.model.ServicesEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"services"})
@EqualsAndHashCode(exclude = {"services"})
@Getter
@Setter
@Entity
@Table(name = "Specialist")
public class SpecialistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String speciality;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "veterinary_id"
    )
    private VeterinaryEntity veterinary;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "specialist_service",
            joinColumns = @JoinColumn(name = "specialist_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<ServicesEntity> services;
}

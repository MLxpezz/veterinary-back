package com.veterinary_system.veterinary.model;

import com.veterinary_system.veterinary.model.enums.DayEnum;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Veterinary_schedule")
public class VeterinaryScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayEnum day;

    @Column(name = "open_hour", nullable = false)
    private String openHour;

    @Column(name = "close_hour", nullable = false)
    private String closeHour;

    @Column(name = "only_emergency", nullable = false)
    private boolean onlyEmergency;

    @ManyToOne
    @JoinColumn(
            name = "veterinary_id"
    )
    private VeterinaryEntity veterinary;
}

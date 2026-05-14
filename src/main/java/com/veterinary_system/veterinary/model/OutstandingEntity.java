package com.veterinary_system.veterinary.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "outstanding")
public class OutstandingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_at")
    private LocalTime startAt;

    @Column(name = "finish_at")
    private LocalTime finishAt;

    @ManyToOne
    @JoinColumn(
            name = "veterinary_id"
    )
    private VeterinaryEntity veterinary;
}

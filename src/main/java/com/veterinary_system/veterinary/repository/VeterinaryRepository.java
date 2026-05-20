package com.veterinary_system.veterinary.repository;

import com.veterinary_system.veterinary.model.VeterinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends JpaRepository<VeterinaryEntity, Long> {
}

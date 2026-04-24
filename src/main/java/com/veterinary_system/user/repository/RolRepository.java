package com.veterinary_system.user.repository;

import com.veterinary_system.user.model.RolEntity;
import com.veterinary_system.user.model.enums.RolEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {

    Optional<RolEntity> findByName(RolEnum name);
}

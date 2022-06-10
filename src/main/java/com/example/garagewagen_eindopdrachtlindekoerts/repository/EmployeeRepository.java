package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.EmployeeEntity;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends EntityGraphJpaRepository<EmployeeEntity, UUID> {
    boolean existsByEmail(final String email);

    Optional<EmployeeEntity> findByEmail(final String email);
}


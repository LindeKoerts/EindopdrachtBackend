package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.VehicleEntity;

public interface VehicleRepository extends EntityGraphJpaRepository<VehicleEntity, String> {
    boolean existsByLicense(final String license);
}

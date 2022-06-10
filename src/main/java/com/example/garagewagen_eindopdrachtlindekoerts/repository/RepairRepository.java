package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.RepairEntity;

import java.util.UUID;

public interface RepairRepository extends EntityGraphJpaRepository<RepairEntity, UUID> {
}

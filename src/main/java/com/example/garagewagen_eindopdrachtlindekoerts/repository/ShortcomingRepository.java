package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.ShortcomingEntity;

import java.util.UUID;

public interface ShortcomingRepository extends EntityGraphJpaRepository<ShortcomingEntity, UUID> {
}

package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.example.garagewagen_eindopdrachtlindekoerts.data.ActionEntity;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;

import java.util.UUID;

public interface ActionRepository extends EntityGraphJpaRepository<ActionEntity, UUID>{
}

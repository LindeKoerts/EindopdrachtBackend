package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.CustomerEntity;

import java.util.UUID;

public interface CustomerRepository extends EntityGraphJpaRepository<CustomerEntity, UUID> {
    boolean existsByEmail(final String email);
}


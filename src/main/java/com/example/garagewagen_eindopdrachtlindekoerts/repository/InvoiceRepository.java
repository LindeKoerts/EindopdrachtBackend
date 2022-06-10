package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.InvoiceEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.projection.InvoiceWithoutDataProjection;

import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends EntityGraphJpaRepository<InvoiceEntity, UUID> {
    List<InvoiceWithoutDataProjection> findAllProjectedBy();
}

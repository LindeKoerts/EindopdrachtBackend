package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.RepairEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.data.RepairLineEntity;

import java.util.List;
import java.util.UUID;

public interface RepairLineRepository extends EntityGraphJpaRepository<RepairLineEntity, UUID> {
    List<RepairLineEntity> findAllByRepair(final RepairEntity repairEntity);
}

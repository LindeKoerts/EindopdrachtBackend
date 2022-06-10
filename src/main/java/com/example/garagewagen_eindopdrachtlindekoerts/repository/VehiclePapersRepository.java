package com.example.garagewagen_eindopdrachtlindekoerts.repository;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.data.VehicleEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.data.VehiclePapersEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.projection.VehiclePapersWithoutDataProjection;

import java.util.List;
import java.util.UUID;

public interface VehiclePapersRepository extends EntityGraphJpaRepository<VehiclePapersEntity, UUID> {
    List<VehiclePapersWithoutDataProjection> findAllProjectedBy();

    List<VehiclePapersWithoutDataProjection> findAllByVehicle(final VehicleEntity vehicleEntity);
}

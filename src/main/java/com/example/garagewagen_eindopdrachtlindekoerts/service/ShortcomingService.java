package com.example.garagewagen_eindopdrachtlindekoerts.service;

import com.example.garagewagen_eindopdrachtlindekoerts.data.ShortcomingEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.data.VehicleEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.repository.ShortcomingRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateShortcomingDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateShortcomingDto;
import com.example.garagewagen_eindopdrachtlindekoerts.mapper.ShortcomingMapper;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ShortcomingService extends BaseRestService<ShortcomingEntity, UUID, CreateShortcomingDto, UpdateShortcomingDto, ShortcomingRepository, ShortcomingMapper> {

    private final VehicleService vehicleService;

    public ShortcomingService(final ShortcomingRepository repository, final ShortcomingMapper mapper, final VehicleService vehicleService) {
        super(repository, mapper);
        this.vehicleService = vehicleService;
    }

    @Override
    protected Optional<ShortcomingEntity> findById(final UUID uuid) {
        return repository.findById(uuid, EntityGraphs.named(ShortcomingEntity.GRAPH_WITH_VEHICLE));
    }

    @Override
    protected ShortcomingEntity fromCreateDto(final CreateShortcomingDto createDto) {
        final ShortcomingEntity shortcomingEntity = mapper.fromCreateDto(createDto);
        final VehicleEntity vehicleEntity = vehicleService.getById(createDto.getVehicleId());
        shortcomingEntity.setVehicle(vehicleEntity);
        return shortcomingEntity;
    }

    @Override
    UUID parseId(final String id) {
        return parseUUID(id);
    }

    @Override
    String entityType() {
        return ShortcomingEntity.class.getSimpleName();
    }
}


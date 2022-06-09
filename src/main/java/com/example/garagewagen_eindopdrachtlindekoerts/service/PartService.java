package com.example.garagewagen_eindopdrachtlindekoerts.service;

import com.example.garagewagen_eindopdrachtlindekoerts.mapper.

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PartService extends BaseRestService<PartEntity, UUID, CreatePartDto, UpdatePartDto, PartRepository, PartMapper> {

    public PartService(final PartRepository repository, final PartMapper mapper) {
        super(repository, mapper);
    }

    @Override
    UUID parseId(final String id) {
        return parseUUID(id);
    }

    @Override
    String entityType() {
        return PartEntity.class.getSimpleName();
    }

    public void decrementStock(final UUID id, final int amount) {
        repository.decrementStock(id, amount);
    }
}


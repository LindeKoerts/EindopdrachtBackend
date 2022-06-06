package com.example.garagewagen_eindopdrachtlindekoerts.service;

import com.example.garagewagen_eindopdrachtlindekoerts.repository.ActionRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.mapper.ActionMapper;
import com.example.garagewagen_eindopdrachtlindekoerts.data.ActionEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateActionDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateActionDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActionService extends BaseRestService<ActionEntity, UUID, CreateActionDto, UpdateActionDto, ActionRepository, ActionMapper> {

    public ActionService(final ActionRepository repository, final ActionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    UUID parseId(final String id) {
        return parseUUID(id);
    }

    @Override
    String entityType() {
        return ActionEntity.class.getSimpleName();
    }
}

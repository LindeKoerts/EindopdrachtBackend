package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.ActionEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateActionDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateActionDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ActionMapper extends EntityMapper<ActionEntity, CreateActionDto, UpdateActionDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    ActionEntity fromCreateDto(final CreateActionDto createDto);

    ActionEntity updateWithDto(final UpdateActionDto updateDto, @MappingTarget final ActionEntity entity);

}

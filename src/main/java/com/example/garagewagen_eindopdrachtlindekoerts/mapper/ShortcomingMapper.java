package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.ShortcomingEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateShortcomingDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateShortcomingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ShortcomingMapper extends EntityMapper<ShortcomingEntity, CreateShortcomingDto, UpdateShortcomingDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    ShortcomingEntity fromCreateDto(final CreateShortcomingDto createDto);

    ShortcomingEntity updateWithDto(final UpdateShortcomingDto updateDto, @MappingTarget final ShortcomingEntity entity);

}


package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.PartEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreatePartDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdatePartDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PartMapper extends EntityMapper<PartEntity, CreatePartDto, UpdatePartDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    PartEntity fromCreateDto(final CreatePartDto createDto);

    PartEntity updateWithDto(final UpdatePartDto updateDto, @MappingTarget final PartEntity entity);

    default double fromDouble(final Double value){
        return value;
    }

}


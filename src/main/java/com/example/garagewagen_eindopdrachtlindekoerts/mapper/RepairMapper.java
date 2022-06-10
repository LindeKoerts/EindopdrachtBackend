package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.RepairEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.domain.RepairStatus;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateRepairDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateRepairDto;

import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RepairMapper extends EntityMapper<RepairEntity, CreateRepairDto, UpdateRepairDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    RepairEntity fromCreateDto(final CreateRepairDto createDto);

    RepairEntity updateWithDto(final UpdateRepairDto updateDto, @MappingTarget final RepairEntity entity);

    default RepairStatus fromInteger(final Integer status) {
        return RepairStatus.parse(status);
    }

    default RepairStatus fromInteger(final int status) {
        return RepairStatus.parse(status);
    }

}

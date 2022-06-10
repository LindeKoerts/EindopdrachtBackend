package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.VehicleEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateVehicleDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateVehicleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface VehicleMapper extends EntityMapper<VehicleEntity, CreateVehicleDto, UpdateVehicleDto> {

    VehicleEntity fromCreateDto(final CreateVehicleDto createDto);

    VehicleEntity updateWithDto(final UpdateVehicleDto updateDto, @MappingTarget final VehicleEntity entity);

}

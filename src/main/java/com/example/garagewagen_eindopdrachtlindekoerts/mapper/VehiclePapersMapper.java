package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.VehiclePapersEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateVehiclePapersDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateVehiclePapersDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface VehiclePapersMapper extends EntityMapper<VehiclePapersEntity, CreateVehiclePapersDto, UpdateVehiclePapersDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    VehiclePapersEntity fromCreateDto(final CreateVehiclePapersDto createDto);

    VehiclePapersEntity updateWithDto(final UpdateVehiclePapersDto updateDto, @MappingTarget final VehiclePapersEntity entity);

}

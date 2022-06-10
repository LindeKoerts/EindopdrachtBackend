package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.domain.Role;
import com.example.garagewagen_eindopdrachtlindekoerts.data.EmployeeEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateEmployeeDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateEmployeeDto;

import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmployeeMapper extends EntityMapper<EmployeeEntity, CreateEmployeeDto, UpdateEmployeeDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    @Mapping(source = "role", target = "role", qualifiedByName = "convertStringToRole")
    EmployeeEntity fromCreateDto(final CreateEmployeeDto createDto);

    @Mapping(source = "role", target = "role", qualifiedByName = "convertStringToRole")
    EmployeeEntity updateWithDto(final UpdateEmployeeDto updateDto, @MappingTarget final EmployeeEntity entity);

    @Named("convertStringToRole")
    default Role convertStringToRole(final String value) {
        return Role.parse(value);
    }

}

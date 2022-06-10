package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateCustomerDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateCustomerDto;
import com.example.garagewagen_eindopdrachtlindekoerts.data.CustomerEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper extends EntityMapper<CustomerEntity, CreateCustomerDto, UpdateCustomerDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    CustomerEntity fromCreateDto(final CreateCustomerDto createDto);

    CustomerEntity updateWithDto(final UpdateCustomerDto updateDto, @MappingTarget final CustomerEntity entity);

}


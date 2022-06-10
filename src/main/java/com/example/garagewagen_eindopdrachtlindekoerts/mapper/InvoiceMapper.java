package com.example.garagewagen_eindopdrachtlindekoerts.mapper;

import com.example.garagewagen_eindopdrachtlindekoerts.data.InvoiceEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.domain.InvoiceStatus;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateInvoiceDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateInvoiceDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface InvoiceMapper extends EntityMapper<InvoiceEntity, CreateInvoiceDto, UpdateInvoiceDto> {

    @Mapping(source = "id", target = "id", qualifiedByName = "parseUUIDOrRandom")
    InvoiceEntity fromCreateDto(final CreateInvoiceDto createDto);

    InvoiceEntity updateWithDto(final UpdateInvoiceDto updateDto, @MappingTarget final InvoiceEntity entity);

    default InvoiceStatus fromInteger(final int status) {
        return InvoiceStatus.parse(status);
    }

}


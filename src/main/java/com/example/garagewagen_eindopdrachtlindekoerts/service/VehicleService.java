package com.example.garagewagen_eindopdrachtlindekoerts.service;

import com.example.garagewagen_eindopdrachtlindekoerts.data.VehicleEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.data.CustomerEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.repository.VehicleRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateVehicleDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateVehicleDto;
import com.example.garagewagen_eindopdrachtlindekoerts.exception.LicenseTakenException;
import com.example.garagewagen_eindopdrachtlindekoerts.mapper.VehicleMapper;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService extends BaseRestService<VehicleEntity, String, CreateVehicleDto, UpdateVehicleDto, VehicleRepository, VehicleMapper> {

    private final CustomerService customerService;

    public VehicleService(final VehicleRepository repository, final VehicleMapper mapper, final CustomerService customerService) {
        super(repository, mapper);
        this.customerService = customerService;
    }

    @Override
    String parseId(final String id) {
        return id;
    }

    @Override
    String entityType() {
        return VehicleEntity.class.getSimpleName();
    }

    @Override
    protected Optional<VehicleEntity> findById(final String s) {
        return repository.findById(s, EntityGraphs.named(VehicleEntity.GRAPH_FULL_DETAILS));
    }

    @Override
    protected void validateCreateConstrains(final CreateVehicleDto createDto) {
        assertLicenseNotTaken(createDto.getLicense());
    }

    @Override
    protected void validateUpdateConstraints(final VehicleEntity entity, final UpdateVehicleDto updateDto) {
        assertLicenseNotTaken(updateDto.getLicense());
    }

    @Override
    protected VehicleEntity fromCreateDto(final CreateVehicleDto createDto) {
        final VehicleEntity vehicleEntity = mapper.fromCreateDto(createDto);
        final CustomerEntity customerEntity = customerService.getById(createDto.getCustomerId());
        vehicleEntity.setOwner(customerEntity);
        return vehicleEntity;
    }

    @Override
    protected VehicleEntity updateWithDto(final VehicleEntity entity, final UpdateVehicleDto updateDto) {
        final VehicleEntity updatedVehicle = super.updateWithDto(entity, updateDto);

        final String customerId = updateDto.getCustomerId();
        if (StringUtils.isNotEmpty(customerId)) {
            final CustomerEntity customerEntity = customerService.getById(customerId);
            updatedVehicle.setOwner(customerEntity);
        }

        return updatedVehicle;
    }

    private void assertLicenseNotTaken(final String license) {
        if (StringUtils.isNotEmpty(license)) {
            if (repository.existsByLicense(license)) {
                throw new LicenseTakenException(license);
            }
        }
    }
}


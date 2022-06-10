package com.example.garagewagen_eindopdrachtlindekoerts.service;

import com.example.garagewagen_eindopdrachtlindekoerts.repository.EmployeeRepository;
import com.example.garagewagen_eindopdrachtlindekoerts.mapper.EmployeeMapper;
import com.example.garagewagen_eindopdrachtlindekoerts.data.EmployeeEntity;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.CreateEmployeeDto;
import com.example.garagewagen_eindopdrachtlindekoerts.dto.UpdateEmployeeDto;
import com.example.garagewagen_eindopdrachtlindekoerts.exception.EmailTakenException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService extends BaseRestService<EmployeeEntity, UUID, CreateEmployeeDto, UpdateEmployeeDto, EmployeeRepository, EmployeeMapper> {

    private final BCryptPasswordEncoder passwordEncoder;

    public EmployeeService(final EmployeeRepository repository, final EmployeeMapper mapper, final BCryptPasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    UUID parseId(final String id) {
        return parseUUID(id);
    }

    @Override
    String entityType() {
        return EmployeeEntity.class.getSimpleName();
    }

    @Override
    protected void validateCreateConstrains(final CreateEmployeeDto createDto) {
        if (repository.existsByEmail(createDto.getEmail())) {
            throw new EmailTakenException(createDto.getEmail());
        }
    }

    @Override
    protected EmployeeEntity fromCreateDto(final CreateEmployeeDto createDto) {
        final EmployeeEntity employeeEntity = mapper.fromCreateDto(createDto);
        final String encodedPassword = passwordEncoder.encode(createDto.getPassword());
        employeeEntity.setPassword(encodedPassword);
        return employeeEntity;
    }

    @Override
    protected EmployeeEntity updateWithDto(final EmployeeEntity entity, final UpdateEmployeeDto updateDto) {
        if (StringUtils.isNotEmpty(updateDto.getPassword())) {
            final String encodedPassword = passwordEncoder.encode(updateDto.getPassword());
            updateDto.setPassword(encodedPassword);
        }
        return super.updateWithDto(entity, updateDto);
    }
}


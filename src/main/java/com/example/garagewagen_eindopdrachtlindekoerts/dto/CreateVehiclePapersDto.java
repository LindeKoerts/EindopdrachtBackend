package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import com.example.garagewagen_eindopdrachtlindekoerts.domain.CreateDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreateVehiclePapersDto implements CreateDto {

    private String id;

    private String name;

    private String type;

    private String vehicleId;

    private byte[] data;

}

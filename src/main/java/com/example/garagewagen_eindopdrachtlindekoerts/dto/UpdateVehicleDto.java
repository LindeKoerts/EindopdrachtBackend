package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@Builder
public class UpdateVehicleDto {

    @Schema(example = "RJ-76-DD", format = "license")
    private String license;

    @Schema(example = "Mini")
    private String brand;

    @Schema(example = "6")
    private String make;

    @Schema(example = "2019")
    @Min(message = "the minimum value is 1886", value = 1886)
    private Integer year;

    @Schema(example = "8102cd51-1f2f-4051-974f-b20dda3ea5ec", format = "uuid")
    private String customerId;

}

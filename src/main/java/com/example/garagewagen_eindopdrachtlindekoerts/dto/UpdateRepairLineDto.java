package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@Builder
public class UpdateRepairLineDto {

    @Schema(example = "Installeren van nieuwe software, radio.")
    private String name;

    @Schema(example = "32.99", format = "double")
    @Min(value = 0, message = "the minimum value is 0")
    private Double price;

    @Schema(example = "1")
    @Min(value = 1, message = "the minimum value is 1")
    private Integer amount;

    @Schema(example = "1", allowableValues = {"0", "1'"})
    private Integer type;

}


package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@Builder
public class UpdateActionDto {

    @Schema(example = "Ruitenvloeistof vervangen")
    private String name;

    @Schema(example = "34.99", format = "double")
    @Min(value = 0, message = "the minimum value is 0")
    public Double price;

}

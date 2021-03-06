package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import com.example.garagewagen_eindopdrachtlindekoerts.domain.CreateDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateActionDto implements CreateDto {

    @Schema(example = "fc6cbf76-837a-4ea6-a20b-0e22f817e55a", format = "uuid")
    private String id;

    @Schema(example = "Vloeistof vervangen")
    @NotBlank(message = "field is required")
    private String name;

    @Schema(example = "Bakker")
    @NotNull(message = "field is required")
    @Min(value = 0, message = "the minimum value is 0")
    private Double price;

}

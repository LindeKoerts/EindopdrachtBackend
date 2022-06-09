package com.example.garagewagen_eindopdrachtlindekoerts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRepairDto {

    @Schema(example = "Nieuwe banden met het juiste profiel zijn toegevoegd.")
    private String remarks;

    @Schema(example = "3", allowableValues = {"0", "1", "2", "3"})
    private Integer status;

}


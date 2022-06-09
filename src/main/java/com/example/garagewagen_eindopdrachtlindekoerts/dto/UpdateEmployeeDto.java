package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEmployeeDto {

    @Schema(example = "Hans")
    private String name;

    @Schema(example = "Rooij")
    private String surname;

    @Schema(example = "Kind2000")
    private String password;

    @Schema(example = "admin", allowableValues = {"admin", "administrative", "backoffice", "cashier", "mechanic"})
    private String role;

}


package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import com.example.garagewagen_eindopdrachtlindekoerts.domain.CreateDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateCustomerDto implements CreateDto {

    @Schema(example = "8102cd51-1f2f-4051-974f-b20dda3ea5ec", format = "uuid")
    private String id;

    @Schema(example = "Bert")
    @NotBlank(message = "field is required")
    private String name;

    @Schema(example = "Koerts")
    @NotBlank(message = "field is required")
    private String surname;

    @Schema(example = "Bert.Koerts@gmail,com", format = "email")
    @Email(message = "isn't a valid email address")
    @NotBlank(message = "field is required")
    private String email;

    @Schema(example = "+31 6 23556786")
    @NotBlank(message = "field is required")
    private String phone;

}

package com.example.garagewagen_eindopdrachtlindekoerts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@Builder
public class UpdateCustomerDto {

    @Schema(example = "Melle")
    private String name;

    @Schema(example = "Mol")
    private String surname;

    @Schema(example = "melle.mol@gmail.com", format = "email")
    @Email(message = "isn't a valid email address")
    private String email;

    @Schema(example = "+31 6 15308765")
    private String phone;

}


package com.example.garagewagen_eindopdrachtlindekoerts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UpdateShortcomingDto {

    @Schema(example = "Raam gaat niet meer dicht, linksvoor.")
    private String description;

}


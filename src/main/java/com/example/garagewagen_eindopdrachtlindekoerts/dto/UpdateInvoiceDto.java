package com.example.garagewagen_eindopdrachtlindekoerts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UpdateInvoiceDto {

    @Schema(example = "1", allowableValues = {"1", "2"})
    private int status;

    @Schema(example = "2022-06-06 T08:33:87.090", format = "date-time")
    private Date paidAt;

}


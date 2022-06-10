package com.example.garagewagen_eindopdrachtlindekoerts.domain;

import com.example.garagewagen_eindopdrachtlindekoerts.exception.UnknownStatusException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum InvoiceStatus {
    OPEN(0),
    PAID(1);

    private final int value;

    public static InvoiceStatus parse(final int value) {
        return Arrays.stream(values())
                .filter(role -> role.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new UnknownStatusException(String.valueOf(value)));
    }

    @JsonValue
    public int getValue() {
        return value;
    }

}

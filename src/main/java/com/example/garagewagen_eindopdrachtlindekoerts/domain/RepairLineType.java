package com.example.garagewagen_eindopdrachtlindekoerts.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;
import com.example.garagewagen_eindopdrachtlindekoerts.exception.UnknownRepairLineException

import java.util.Arrays;

@RequiredArgsConstructor
public enum RepairLineType {
    PART(0),
    ACTION(1);

    private final int value;

    public static RepairLineType parse(final int value) {
        return Arrays.stream(values())
                .filter(role -> role.getValue() == value)
                .findFirst()
                .orElseThrow(() -> new UnknownRepairLineException(value));
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}


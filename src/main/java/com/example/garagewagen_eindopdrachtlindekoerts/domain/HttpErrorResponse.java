package com.example.garagewagen_eindopdrachtlindekoerts.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HttpErrorResponse {

    private final int statusCode;
    private final String errorCode;
    private final String message;

}

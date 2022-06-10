package com.example.garagewagen_eindopdrachtlindekoerts.exception;

import org.springframework.http.HttpStatus;

public class UnknownRepairLineException extends BaseHttpException{
    public static final String ERROR_CODE = "unknown-repair-line-type";

    public UnknownRepairLineException(final int type) {
        super(ERROR_CODE, HttpStatus.BAD_REQUEST, String.format("type %d is unknown", type));
    }

}

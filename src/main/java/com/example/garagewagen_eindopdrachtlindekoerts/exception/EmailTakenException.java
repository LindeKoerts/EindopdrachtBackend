package com.example.garagewagen_eindopdrachtlindekoerts.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatus;

public class EmailTakenException extends BaseHttpException {

    public static final String ERROR_CODE = "email-already-taken";

    public EmailTakenException(final String email) {
        super(ERROR_CODE, HttpStatus.BAD_REQUEST, String.format("email address %s is already taken", email));
    }
}
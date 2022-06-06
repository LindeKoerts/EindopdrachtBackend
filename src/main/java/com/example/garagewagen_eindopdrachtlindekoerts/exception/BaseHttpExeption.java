package com.example.garagewagen_eindopdrachtlindekoerts.exception;

package com.example.garagewagen_eindopdrachtlindekoerts.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseHttpException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus status;
    private final String message;

    public BaseHttpException(final String errorCode, final HttpStatus httpStatus, final String message) {
        this.errorCode = errorCode;
        this.status = httpStatus;
        this.message = message;
    }

    public HttpErrorResponse getBody(){
        return new HttpErrorResponse(status.value(), errorCode, message);
    }
}


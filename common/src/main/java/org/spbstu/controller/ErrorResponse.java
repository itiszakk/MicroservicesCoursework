package org.spbstu.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {
    private final int code;
    private final String type;
    private final String message;

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.code = httpStatus.value();
        this.type = httpStatus.getReasonPhrase();
        this.message = message;
    }
}

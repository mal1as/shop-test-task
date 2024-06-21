package com.mal1as.exception.handler;

import com.mal1as.exception.ValidationException;
import com.mal1as.model.dto.response.ErrorResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class, jakarta.validation.ValidationException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .message(e.getMessage())
                        .status(HttpStatus.BAD_REQUEST.name())
                        .stackTrace(ExceptionUtils.getStackTrace(e))
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .message(e.getMessage())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                        .stackTrace(ExceptionUtils.getStackTrace(e))
                        .build());
    }
}

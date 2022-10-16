package com.matheus.leite.rotatematrix.handler;

import com.matheus.leite.rotatematrix.domain.ErrorDetails;
import com.matheus.leite.rotatematrix.error.message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> handleErrorOnRotateMatrixJsonParsingData(
            Exception e,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDetails(
                                ErrorMessage.JSON_PARSE_ERROR,
                                HttpStatus.BAD_REQUEST.value(),
                                System.currentTimeMillis()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleUnexpectedError(
            Exception e,
            HttpServletRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDetails(
                                ErrorMessage.UNEXPECTED_ERROR,
                                HttpStatus.BAD_REQUEST.value(),
                                System.currentTimeMillis()
                        )
                );
    }
}

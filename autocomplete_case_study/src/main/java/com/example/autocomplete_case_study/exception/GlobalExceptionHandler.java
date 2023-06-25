package com.example.autocomplete_case_study.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.autocomplete_case_study.model.ErrorResponse;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * This class contains the methods that define the response for different exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleItemNotFoundException() {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ErrorTypes.ITEM_NOT_FOUND.getCode());
        errorResponse.setErrorDescription(ErrorTypes.ITEM_NOT_FOUND.getDescription());
        ResponseEntity response = new ResponseEntity<>(errorResponse.getResponse(), HttpStatus.BAD_REQUEST);
        return response;

    }


    @ExceptionHandler(IllegalCharacterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleIllegalCharacterException() {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ErrorTypes.ILLEGAL_CHARACTER.getCode());
        errorResponse.setErrorDescription(ErrorTypes.ILLEGAL_CHARACTER.getDescription());
        ResponseEntity response = new ResponseEntity<>(errorResponse.getResponse(), HttpStatus.BAD_REQUEST);
        return response;

    }

    @ExceptionHandler(InputTooLongException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleInputTooLongException() {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ErrorTypes.INPUT_TOO_LONG.getCode());
        errorResponse.setErrorDescription(ErrorTypes.INPUT_TOO_LONG.getDescription());
        ResponseEntity response = new ResponseEntity<>(errorResponse.getResponse(), HttpStatus.BAD_REQUEST);
        return response;

    }


    @ExceptionHandler(InputTooShortException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleInputTooShortException() {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ErrorTypes.INPUT_TOO_SHORT.getCode());
        errorResponse.setErrorDescription(ErrorTypes.INPUT_TOO_SHORT.getDescription());
        ResponseEntity response = new ResponseEntity<>(errorResponse.getResponse(), HttpStatus.BAD_REQUEST);
        return response;

    }
}

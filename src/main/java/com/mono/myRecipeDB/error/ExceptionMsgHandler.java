package com.mono.myRecipeDB.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMsgHandler {

    @ExceptionHandler(MessageNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorData handleException (Throwable ex) {

        return new ErrorData(ex.getMessage());
    }



}

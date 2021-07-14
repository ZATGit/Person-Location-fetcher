package com.ts.person.exception;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {
    @ExceptionHandler(value = UniqueConstraintException.class)
    public ResponseEntity<Object> exception(UniqueConstraintException exception) {
        List<String> info = new ArrayList<>();
        info.add("400 Bad Request");
        info.add(exception.getLocalizedMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ZipCodeNotFoundException.class)
    public ResponseEntity<Object> exception(ZipCodeNotFoundException exception) {
        List<String> info = new ArrayList<>();
        info.add("404 Not Found");
        info.add(exception.getLocalizedMessage());
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }
}

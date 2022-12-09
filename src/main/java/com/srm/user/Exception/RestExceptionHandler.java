package com.srm.user.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest requset) {

        ExceptionMessage exceptionMessageObj = new ExceptionMessage();

        // Handle All Field Validation Errors
        if (ex instanceof MethodArgumentNotValidException) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
                sb.append(";");
            }
            exceptionMessageObj.setMessage(sb.toString());
        } else {
            exceptionMessageObj.setMessage(ex.getLocalizedMessage());
        }

        exceptionMessageObj.setError(ex.getClass().getCanonicalName());
        exceptionMessageObj.setPath(((ServletWebRequest) requset).getRequest().getServletPath());
        exceptionMessageObj.setCode("400");

        // return exceptionMessageObj;
        return new ResponseEntity<>(exceptionMessageObj, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

//@RestControllerAdvice
//public class RestExceptionHandler {
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity handleValidationException(MethodArgumentNotValidException ex)
//    {
//        return new ResponseEntity(ex.getDetailMessageArguments() , HttpStatus.BAD_REQUEST);
//    }
//}

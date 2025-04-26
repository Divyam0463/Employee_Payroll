package com.example.employee_payroll.Advice;

import com.example.employee_payroll.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class App_ExceptionHandler
{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> NotFound_method(MethodArgumentNotValidException ex){
        Map<String,String> error_map = new HashMap<>() ;
        ex.getBindingResult().getFieldErrors().forEach((error)->
                error_map.put(error.getField(),error.getDefaultMessage())
        );
        return error_map ;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> userNotFound(UserNotFoundException ex){
        Map<String,String> error_map = new HashMap<>();
        error_map.put("errorMessage",ex.getMessage()) ;
        return error_map ;
    }
}

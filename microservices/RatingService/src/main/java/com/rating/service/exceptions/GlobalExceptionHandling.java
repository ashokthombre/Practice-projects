package com.rating.service.exceptions;

import com.rating.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        String message = ex.getMessage();
        Map<String,Object> map=new HashMap<>();
        map.put("message",message);
        map.put("success",true);
        map.put("status", HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }

}

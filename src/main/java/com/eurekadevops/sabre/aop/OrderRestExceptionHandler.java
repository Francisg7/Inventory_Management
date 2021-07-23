package com.eurekadevops.sabre.aop;

import com.eurekadevops.sabre.web.errors.OrderErrorResponse;
import com.eurekadevops.sabre.web.errors.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderRestExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException exception) {
        OrderErrorResponse error = new OrderErrorResponse();
        
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}

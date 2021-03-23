/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugstore.products.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author danie
 */
@RestControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIExcpetionResponse> handleNoContentException(Exception ex){
        APIExcpetionResponse resp=new APIExcpetionResponse();
        resp.setCode("0");
        resp.setTitle("Uncathegorized exception");
        resp.setDetail(ex.getMessage());
        return new ResponseEntity(resp,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<APIExcpetionResponse> handleBusinessRuleException(BusinessRuleException ex){
        APIExcpetionResponse resp=new APIExcpetionResponse();
        resp.setCode(ex.getCode());
        resp.setTitle("Business rule exception");
        resp.setDetail(ex.getMessage());
        return new ResponseEntity(resp,HttpStatus.BAD_REQUEST);
        
    }
    
}

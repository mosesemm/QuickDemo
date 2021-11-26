package com.example.moneyquoteapp.util;

import com.example.moneyquoteapp.model.UssdResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<UssdResponse> handleGeneralException(Exception ex, WebRequest req, HttpServletRequest servletRequest) {
        UssdResponse response = new UssdResponse();
        response.setMessage("Unexpected error occurred with your request");
        //TODO: it will be nice to get the sessionId and correlate the error back, struggling to get request body till next time
        log.error(servletRequest.getServletPath(), ex);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

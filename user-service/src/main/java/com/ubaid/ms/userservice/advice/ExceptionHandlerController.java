package com.ubaid.ms.userservice.advice;

import com.ubaid.ms.ccdto.ExceptionDTO;
import com.ubaid.ms.module.ccexception.CCException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(CCException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ExceptionDTO> handle3CNException(CCException exp) {

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exp.getMessage());
        exceptionDTO.setCause(exp.getCause().toString());
        exceptionDTO.setTimeStamp(new Date());

        return Mono.just(exceptionDTO);
    }
}

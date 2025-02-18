package br.com.itau.veiculos.challenge.application.config;

import br.com.itau.veiculos.challenge.domain.utils.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class, IllegalStateException.class})
    protected ResponseEntity<Object> response() {
        return ResponseEntity.status(500).body(Message.INTERNAL_SERVER_ERROR);
    }
}
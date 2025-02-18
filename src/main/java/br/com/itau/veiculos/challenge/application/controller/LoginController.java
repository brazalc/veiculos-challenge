package br.com.itau.veiculos.challenge.application.controller;

import br.com.itau.veiculos.challenge.application.dto.LoginResponse;
import br.com.itau.veiculos.challenge.domain.service.DomainLoginService;
import br.com.itau.veiculos.challenge.domain.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger
            = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private DomainLoginService domainLoginService;

    @PostMapping
    public ResponseEntity<LoginResponse> createLogin(String loginRequest) {
        logger.info(Message.CREATE_PRODUCT);
        var response = domainLoginService.createLogin(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

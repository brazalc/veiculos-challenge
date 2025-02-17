package br.com.itau.veiculos.challenge.com.itau.veiculos.challenge.domain.service;

import br.com.itau.veiculos.challenge.com.itau.veiculos.challenge.application.dto.LoginResponse;

public interface LoginInterface {
    LoginResponse createLogin(String req);
}

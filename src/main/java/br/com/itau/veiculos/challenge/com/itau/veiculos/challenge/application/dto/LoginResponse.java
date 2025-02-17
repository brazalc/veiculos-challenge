package br.com.itau.veiculos.challenge.com.itau.veiculos.challenge.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    @JsonProperty("isOk")
    private Boolean isOk;
    @JsonProperty("response")
    private String response;

    public LoginResponse() {
    }

    public LoginResponse(Boolean isOk, String response) {
        this.isOk = isOk;
        this.response = response;
    }

    public Boolean getIsOk() {
        return isOk;
    }

    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

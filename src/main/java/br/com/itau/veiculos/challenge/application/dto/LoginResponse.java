package br.com.itau.veiculos.challenge.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public Boolean isSuccess() {
        return success;
    }


    public String getMessage() {
        return message;
    }
}

package br.com.itau.veiculos.challenge.strategy;

public interface PasswordValidationInterface {
    boolean validate(String password);

    String getErrorMessage();
}

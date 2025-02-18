package br.com.itau.veiculos.challenge.strategy;

public class RepeatedCharValidationInterface implements PasswordValidationInterface {
    @Override
    public boolean validate(String password) {
        return password.chars().distinct().count() == password.length();
    }

    @Override
    public String getErrorMessage() {
        return "A senha não deve conter caracteres repetidos";
    }
}

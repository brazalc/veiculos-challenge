package br.com.itau.veiculos.challenge.strategy;

import java.util.regex.Pattern;

public class DigitValidationInterface implements PasswordValidationInterface {

    private static final String DIGIT_PATTERN = ".*[0-9].*";

    @Override
    public boolean validate(String password) {
        return Pattern.compile(DIGIT_PATTERN).matcher(password).matches();
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve conter pelo menos um dígito";
    }
}

package br.com.itau.veiculos.challenge.strategy;

import java.util.regex.Pattern;

public class SpecialCharValidationInterface implements PasswordValidationInterface {

    private static final String SPECIAL_CHAR_PATTERN = ".*[!@#$%^&*()\\-+].*";

    @Override
    public boolean validate(String password) {
        return Pattern.compile(SPECIAL_CHAR_PATTERN).matcher(password).matches();
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve conter pelo menos um caractere especial";
    }
}

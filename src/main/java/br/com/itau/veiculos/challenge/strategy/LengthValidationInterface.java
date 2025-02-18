package br.com.itau.veiculos.challenge.strategy;

import java.util.regex.Pattern;

public class LengthValidationInterface implements PasswordValidationInterface {

    private static final String LENGTH_PATTERN = ".{9,}";
    @Override
    public boolean validate(String password) {
        return Pattern.compile(LENGTH_PATTERN).matcher(password).matches();
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve ter pelo menos 9 caracteres";
    }
}

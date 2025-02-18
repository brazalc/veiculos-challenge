package br.com.itau.veiculos.challenge.strategy;

import java.util.regex.Pattern;

public class UpperCaseValidationInterface implements PasswordValidationInterface {

    private static final String UPPERCASE_PATTERN = ".*[A-Z].*";

    @Override
    public boolean validate(String password) {
        return Pattern.compile(UPPERCASE_PATTERN).matcher(password).matches();
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve conter pelo menos uma letra maiúscula";
    }
}

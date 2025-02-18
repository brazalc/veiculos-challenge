package br.com.itau.veiculos.challenge.strategy;

import java.util.regex.Pattern;

public class LowerCaseValidationInterface implements PasswordValidationInterface {

    private static final String LOWERCASE_PATTERN = ".*[a-z].*";

    @Override
    public boolean validate(String password) {
        return Pattern.compile(LOWERCASE_PATTERN).matcher(password).matches();
    }

    @Override
    public String getErrorMessage() {
        return "A senha deve conter pelo menos uma letra minúscula";
    }
}

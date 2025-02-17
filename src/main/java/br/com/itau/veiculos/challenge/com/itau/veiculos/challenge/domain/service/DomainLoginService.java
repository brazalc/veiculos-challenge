package br.com.itau.veiculos.challenge.com.itau.veiculos.challenge.domain.service;

import br.com.itau.veiculos.challenge.com.itau.veiculos.challenge.application.dto.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class DomainLoginService implements LoginInterface {

    private static final org.slf4j.Logger logger
            = org.slf4j.LoggerFactory.getLogger(DomainLoginService.class);

    private static final String DIGIT_PATTERN = ".*[0-9].*";
    private static final String LOWERCASE_PATTERN = ".*[a-z].*";
    private static final String UPPERCASE_PATTERN = ".*[A-Z].*";
    private static final String SPECIAL_CHAR_PATTERN = ".*[!@#$%^&*()\\-+].*";
    private static final String LENGTH_PATTERN = ".{9,}";
    private static final Boolean FALSE = false;
    @Override
    public LoginResponse createLogin(String password) {
        if (password == null) {
            return new LoginResponse(FALSE, "A senha não pode ser nula");
        }
        if (!Pattern.compile(LENGTH_PATTERN).matcher(password).matches()) {
            return new LoginResponse(FALSE, "A senha deve ter pelo menos 9 caracteres");
        }
        if (!Pattern.compile(DIGIT_PATTERN).matcher(password).matches()) {
            return new LoginResponse(FALSE, "A senha deve conter pelo menos um dígito");
        }
        if (!Pattern.compile(LOWERCASE_PATTERN).matcher(password).matches()) {
            return new LoginResponse(FALSE, "A senha deve conter pelo menos uma letra minúscula");
        }
        if (!Pattern.compile(UPPERCASE_PATTERN).matcher(password).matches()) {
            return new LoginResponse(FALSE, "A senha deve conter pelo menos uma letra maiúscula");
        }
        if (!Pattern.compile(SPECIAL_CHAR_PATTERN).matcher(password).matches()) {
            return new LoginResponse(FALSE, "A senha deve conter pelo menos um caractere especial (!@#$%^&*()-+)");
        }
        if (password.chars().distinct().count() != password.length()) {
            return new LoginResponse(FALSE, "A senha não deve conter caracteres repetidos");
        }
        return new LoginResponse(!FALSE, "Senha válida");
    }
}

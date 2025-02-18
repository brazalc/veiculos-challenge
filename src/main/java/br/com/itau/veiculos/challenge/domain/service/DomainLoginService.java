package br.com.itau.veiculos.challenge.domain.service;

import br.com.itau.veiculos.challenge.application.dto.LoginResponse;
import br.com.itau.veiculos.challenge.domain.utils.Message;
import br.com.itau.veiculos.challenge.strategy.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomainLoginService implements LoginInterface {

    private static final org.slf4j.Logger logger
            = org.slf4j.LoggerFactory.getLogger(DomainLoginService.class);
    private static final Boolean FALSE = false;

    private final List<PasswordValidationInterface> validationStrategies = new ArrayList<>();

    public DomainLoginService() {
        validationStrategies.add(new LengthValidationInterface());
        validationStrategies.add(new DigitValidationInterface());
        validationStrategies.add(new LowerCaseValidationInterface());
        validationStrategies.add(new UpperCaseValidationInterface());
        validationStrategies.add(new SpecialCharValidationInterface());
        validationStrategies.add(new RepeatedCharValidationInterface());
    }
    @Override
    public LoginResponse createLogin(String password) {
        try {
            if (password == null) {
                return new LoginResponse(FALSE, "A senha não pode ser nula");
            }
            for (PasswordValidationInterface strategy : validationStrategies) {
                if (!strategy.validate(password)) {
                    return new LoginResponse(FALSE, strategy.getErrorMessage());
                }
            }
            return new LoginResponse(!FALSE, "Senha válida");
        } catch (IllegalArgumentException e) {
            logger.error(Message.ERROR_PASSWORD_VALIDATION, e);
            return new LoginResponse(FALSE, Message.ERROR_PASSWORD_VALIDATION);
        }
    }
}

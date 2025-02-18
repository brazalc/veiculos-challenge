package br.com.itau.veiculos.challenge.domain.service;

import br.com.itau.veiculos.challenge.application.dto.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DomainLoginServiceTest {

    @InjectMocks
    private DomainLoginService domainLoginService;

    @BeforeEach
    void setUp() {
        domainLoginService = new DomainLoginService();
    }

    @Test
    void testCreateLogin_NullPassword() {
        LoginResponse response = domainLoginService.createLogin(null);
        assertFalse(response.isSuccess());
        assertEquals("A senha não pode ser nula", response.getMessage());
    }

    @Test
    void testCreateLogin_InvalidLength() {
        LoginResponse response = domainLoginService.createLogin("short");
        assertFalse(response.isSuccess());
        assertEquals("A senha deve ter pelo menos 9 caracteres", response.getMessage());
    }

    @Test
    void testCreateLogin_NoDigit() {
        LoginResponse response = domainLoginService.createLogin("NoDigits!");
        assertFalse(response.isSuccess());
        assertEquals("A senha deve conter pelo menos um dígito", response.getMessage());
    }

    @Test
    void testCreateLogin_NoLowerCase() {
        LoginResponse response = domainLoginService.createLogin("NOLOWERCASE1!");
        assertFalse(response.isSuccess());
        assertEquals("A senha deve conter pelo menos uma letra minúscula", response.getMessage());
    }

    @Test
    void testCreateLogin_NoUpperCase() {
        LoginResponse response = domainLoginService.createLogin("nouppercase1!");
        assertFalse(response.isSuccess());
        assertEquals("A senha deve conter pelo menos uma letra maiúscula", response.getMessage());
    }

    @Test
    void testCreateLogin_NoSpecialChar() {
        LoginResponse response = domainLoginService.createLogin("NoSpecialChar1");
        assertFalse(response.isSuccess());
        assertEquals("A senha deve conter pelo menos um caractere especial", response.getMessage());
    }

    @Test
    void testCreateLogin_RepeatedChar() {
        LoginResponse response = domainLoginService.createLogin("RepeatedChar1!!");
        assertFalse(response.isSuccess());
        assertEquals("A senha não deve conter caracteres repetidos", response.getMessage());
    }

    @Test
    void testCreateLogin_ValidPassword() {
        LoginResponse response = domainLoginService.createLogin("ValiD1PAs$word");
        assertTrue(response.isSuccess());
        assertEquals("Senha válida", response.getMessage());
    }
}
package com.accountblock.tests;


import accountblock.repository.ContaRepository;
import accountblock.service.AccountService;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    void deveRetornarVerdadeiroAoBloquearContaNoRepositorio() {
        // 1. Criar o mock
        ContaRepository repoMock = mock(ContaRepository.class);

        // 2. Definir comportamento esperado
        when(repoMock.bloquearConta(12345)).thenReturn(true);

        // 3. Usar o mock na classe que vamos testar
        AccountService service = new AccountService(repoMock);
        boolean bloqueado = service.bloquearConta(12345, "fraude detectada");

        // 4. Verificar resultado
        assertTrue(bloqueado);
        verify(repoMock, times(1)).bloquearConta(12345);
    }
}


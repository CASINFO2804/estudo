package com.accountblock.service;

public class AccountService {
    public boolean bloquearConta(int idConta, String motivo) {
        // Lógica real para bloquear a conta (ou um mock inicial)
        System.out.println("Bloqueando conta " + idConta + " por " + motivo);
        return true; // só pra teste
    }
}

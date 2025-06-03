package com.tsswebapps.financesiapersonal.application.port.out;

public interface AlterarSenhaUsuarioRepositoryPort {
    void execute(Long id, String novaSenha);
}

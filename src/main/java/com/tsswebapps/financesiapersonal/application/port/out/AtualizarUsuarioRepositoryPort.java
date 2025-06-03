package com.tsswebapps.financesiapersonal.application.port.out;

import com.tsswebapps.financesiapersonal.domain.model.Usuario;

public interface AtualizarUsuarioRepositoryPort {
    void execute(Usuario usuario);
}

package com.tsswebapps.financesiapersonal.application.port.out;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioResponse;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;

public interface CadastrarUsuarioRepositoryPort {
    UsuarioResponse execute(Usuario usuario);
}

package com.tsswebapps.financesiapersonal.application.port.in;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioRequest;
import com.tsswebapps.financesiapersonal.application.dto.UsuarioResponse;

public interface CadastrarUsuarioUseCasePort {
    UsuarioResponse execute(UsuarioRequest usuarioRequest);
}

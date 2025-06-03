package com.tsswebapps.financesiapersonal.application.port.out;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioLogin;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;

import java.util.Optional;

public interface BuscarUsuarioRepositoryPort {
    Optional<Usuario> buscar(UsuarioLogin usuarioLogin);
    Optional<Usuario> buscarPorId(Long id);
}

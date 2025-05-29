package com.tsswebapps.financesiapersonal.application.port.out;

import com.tsswebapps.financesiapersonal.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    void Cadastrar(Usuario usuario);
    Optional<Usuario> BuscarPorEmailSenha(String email, String senha);
}

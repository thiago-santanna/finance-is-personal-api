package com.tsswebapps.financesiapersonal.application.port.out;

import com.tsswebapps.financesiapersonal.application.port.out.dto.UsuarioLogin;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    void cadastrar(Usuario usuario);
    Optional<Usuario> buscarPorEmailSenha(UsuarioLogin usuarioLogin);
    Optional<Usuario> buscarPorId(Long id);
    void atualizar(Usuario usuario);
    void deletar(Long id);
    void alterarSenha(Long id, String novaSenha);

}

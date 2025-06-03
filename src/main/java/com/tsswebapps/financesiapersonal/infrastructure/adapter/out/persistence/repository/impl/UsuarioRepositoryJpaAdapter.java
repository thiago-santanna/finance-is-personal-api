package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.repository.impl;

import com.tsswebapps.financesiapersonal.application.port.out.UsuarioRepositoryPort;
import com.tsswebapps.financesiapersonal.application.port.out.dto.UsuarioLogin;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;
import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.repository.jparepository.UsuarioRepository;
import com.tsswebapps.financesiapersonal.infrastructure.mapper.UsuarioEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryJpaAdapter implements UsuarioRepositoryPort {

    private final UsuarioEntityMapper mapper;
    private final UsuarioRepository repository;

    public UsuarioRepositoryJpaAdapter(UsuarioEntityMapper mapper, UsuarioRepository repository) {this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void cadastrar(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
    }

    @Override
    public Optional<Usuario> buscarPorEmailSenha(UsuarioLogin usuarioLogin) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void atualizar(Usuario usuario) {

    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void alterarSenha(Long id, String novaSenha) {

    }
}

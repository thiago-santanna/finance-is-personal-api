package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.repository.impl;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioResponse;
import com.tsswebapps.financesiapersonal.application.mapper.UsuarioResponseMapper;
import com.tsswebapps.financesiapersonal.application.port.out.CadastrarUsuarioRepositoryPort;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;
import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.repository.jparepository.UsuarioRepository;
import com.tsswebapps.financesiapersonal.infrastructure.mapper.UsuarioEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CadastrarUsuarioRepositoryAdapter implements CadastrarUsuarioRepositoryPort {

    private final UsuarioEntityMapper mapper;
    private final UsuarioRepository repository;
    private final UsuarioResponseMapper responseMapper;

    public CadastrarUsuarioRepositoryAdapter(UsuarioEntityMapper mapper, UsuarioRepository repository, UsuarioResponseMapper responseMapper) {this.mapper = mapper;
        this.repository = repository;
        this.responseMapper = responseMapper;
    }

    @Override
    public UsuarioResponse execute(Usuario usuario) {
        return responseMapper.toResponse(repository.save(mapper.toEntity(usuario)));
    }
}

package com.tsswebapps.financesiapersonal.application.usecase;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioRequest;
import com.tsswebapps.financesiapersonal.application.dto.UsuarioResponse;
import com.tsswebapps.financesiapersonal.application.mapper.UsuarioRequestMapper;
import com.tsswebapps.financesiapersonal.application.port.in.CadastrarUsuarioUseCasePort;
import com.tsswebapps.financesiapersonal.application.port.out.CadastrarUsuarioRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastrarUsuarioUseCaseImpl implements CadastrarUsuarioUseCasePort {

    private final CadastrarUsuarioRepositoryPort usuarioRepositoryPort;
    private final UsuarioRequestMapper requestMapper;

    public CadastrarUsuarioUseCaseImpl(CadastrarUsuarioRepositoryPort usuarioRepositoryPort, UsuarioRequestMapper requestMapper) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.requestMapper = requestMapper;
    }

    @Override
    @Transactional
    public UsuarioResponse execute(UsuarioRequest usuarioRequest) {
        return usuarioRepositoryPort.execute(requestMapper.toModel(usuarioRequest));
    }
}

package com.tsswebapps.financesiapersonal.infrastructure.adapter.in.controller;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioRequest;
import com.tsswebapps.financesiapersonal.application.dto.UsuarioResponse;
import com.tsswebapps.financesiapersonal.application.port.in.CadastrarUsuarioUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCasePort cadastrarUsuarioUseCasePort;

    public UsuarioController(CadastrarUsuarioUseCasePort cadastrarUsuarioUseCasePort) {
        this.cadastrarUsuarioUseCasePort = cadastrarUsuarioUseCasePort;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse executed = cadastrarUsuarioUseCasePort.execute(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(executed);
    }
}

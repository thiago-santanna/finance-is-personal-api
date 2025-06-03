package com.tsswebapps.financesiapersonal.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        @JsonIgnore
        String senha,
        String telefone
) {
}

package com.tsswebapps.financesiapersonal.domain.model;

public record Usuario(
        Long id,
        String nome,
        String email,
        String senha,
        String telefone
) {
}

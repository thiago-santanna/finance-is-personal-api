package com.tsswebapps.financesiapersonal.domain.model;

public record Debito(
        Long id,
        Usuario usuario,
        String descricao
) {
}

package com.tsswebapps.financesiapersonal.domain.model;

public record Categoria(
        Long id,
        Usuario usuario,
        String nome,
        String descricao
) {
}

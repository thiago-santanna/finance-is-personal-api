package com.tsswebapps.financesiapersonal.domain.model;

public record Operacao(
        Long id,
        Usuario usuario,
        String descricao,
        TipoOperacao tipoOperacao
) {
}

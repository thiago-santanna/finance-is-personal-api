package com.tsswebapps.financesiapersonal.exception.dto;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Representa uma resposta de erro padronizada para a API.
 * Utiliza Java Record para concisão (disponível desde Java 14+).
 *
 * @param status O código de status HTTP.
 * @param timestamp O momento em que o erro ocorreu.
 * @param titulo Uma descrição geral do erro.
 * @param detalhe Uma mensagem mais específica sobre o erro.
 * @param camposValidados (Opcional) Um mapa de campos e suas respectivas mensagens de erro de validação.
 */
public record ErrorResponse(
        int status,
        OffsetDateTime timestamp,
        String titulo,
        String detalhe,
        Map<String, List<String>> camposValidados // Para erros de validação
) {
    // Construtor simplificado para erros gerais
    public ErrorResponse(int status, String titulo, String detalhe) {
        this(status, OffsetDateTime.now(), titulo, detalhe, null);
    }

    // Construtor para erros de validação
    public ErrorResponse(int status, String titulo, String detalhe, Map<String, List<String>> camposValidados) {
        this(status, OffsetDateTime.now(), titulo, detalhe, camposValidados);
    }
}

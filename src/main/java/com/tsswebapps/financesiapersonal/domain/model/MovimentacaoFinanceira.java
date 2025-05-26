package com.tsswebapps.financesiapersonal.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovimentacaoFinanceira(
    Long id,
    Usuario usuario,
    Operacao operacao,
    LocalDate dataMovimentacao,
    BigDecimal valor,
    String descricao,
    String observacao
) {

}

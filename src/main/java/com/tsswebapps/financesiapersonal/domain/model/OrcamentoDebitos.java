package com.tsswebapps.financesiapersonal.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OrcamentoDebitos(
    Long id,
    Usuario usuario,
    Debito debito,
    Situacao situacao,
    LocalDate dataLancamento,
    Operacao operacao,
    Categoria categoria,
    TipoGasto tipoGasto,
    MovimentacaoFinanceira movimentacaoFinanceira,
    ComprasParceladas comprasParcelas,
    BigDecimal valor,
    String descricao,
    String observacao
) {

}

package com.tsswebapps.financesiapersonal.domain.model;

import java.math.BigDecimal;

public record ComprasParceladas(
    Long id,
    Usuario usuario,
    Debito debito,
    int qtdParcelas,
    int qtdParcelasPagas,
    BigDecimal valorTotal,
    BigDecimal valorPago,
    BigDecimal valorParcela,
    String observacao
) {

}

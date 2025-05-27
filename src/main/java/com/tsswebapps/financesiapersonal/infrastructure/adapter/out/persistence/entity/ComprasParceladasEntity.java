package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_parceladas")
public class ComprasParceladasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "debito_id", nullable = false)
    private DebitoEntity debito;

    @Column(name = "qtd_parcelas", nullable = false)
    private int qtdParcelas;

    @Column(name = "qtd_parcelas_pagas", nullable = false)
    private int qtdParcelasPagas;

    @Column(name = "valor_total", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "valor_pago", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "valor_parcela", nullable = false, precision = 19, scale = 2)
    private BigDecimal valorParcela;

    @Column(length = 500)
    private String observacao;

    // Construtor padrão exigido pelo JPA
    public ComprasParceladasEntity() {
    }

    public ComprasParceladasEntity(Long id, UsuarioEntity usuario, DebitoEntity debito, int qtdParcelas, int qtdParcelasPagas, BigDecimal valorTotal, BigDecimal valorPago, BigDecimal valorParcela, String observacao) {
        this.id = id;
        this.usuario = usuario;
        this.debito = debito;
        this.qtdParcelas = qtdParcelas;
        this.qtdParcelasPagas = qtdParcelasPagas;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.valorParcela = valorParcela;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public DebitoEntity getDebito() {
        return debito;
    }

    public void setDebito(DebitoEntity debito) {
        this.debito = debito;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public int getQtdParcelasPagas() {
        return qtdParcelasPagas;
    }

    public void setQtdParcelasPagas(int qtdParcelasPagas) {
        this.qtdParcelasPagas = qtdParcelasPagas;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComprasParceladasEntity that = (ComprasParceladasEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ComprasParceladasEntity{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getId() : "null") +
                ", debito=" + (debito != null ? debito.getId() : "null") +
                ", qtdParcelas=" + qtdParcelas +
                ", qtdParcelasPagas=" + qtdParcelasPagas +
                ", valorTotal=" + valorTotal +
                ", valorPago=" + valorPago +
                ", valorParcela=" + valorParcela +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

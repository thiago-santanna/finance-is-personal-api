package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "movimentacao_financeira")
public class MovimentacaoFinanceiraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "operacao_id", nullable = false)
    private OperacaoEntity operacao; // Assumindo que Operacao se tornou OperacaoEntity

    @Column(name = "data_movimentacao", nullable = false)
    private LocalDate dataMovimentacao;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(length = 500)
    private String observacao;

    // Construtor padrão exigido pelo JPA
    public MovimentacaoFinanceiraEntity() {
    }

    public MovimentacaoFinanceiraEntity(Long id, UsuarioEntity usuario, OperacaoEntity operacao, LocalDate dataMovimentacao, BigDecimal valor, String descricao, String observacao) {
        this.id = id;
        this.usuario = usuario;
        this.operacao = operacao;
        this.dataMovimentacao = dataMovimentacao;
        this.valor = valor;
        this.descricao = descricao;
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

    public OperacaoEntity getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoEntity operacao) {
        this.operacao = operacao;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        MovimentacaoFinanceiraEntity that = (MovimentacaoFinanceiraEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MovimentacaoFinanceiraEntity{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getId() : "null") +
                ", operacao=" + (operacao != null ? operacao.getId() : "null") +
                ", dataMovimentacao=" + dataMovimentacao +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.tsswebapps.financesiapersonal.domain.model.Situacao;
import com.tsswebapps.financesiapersonal.domain.model.TipoGasto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamento_debitos")
public class OrcamentoDebitosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario; // Alterado de Usuario para UsuarioEntity

    @ManyToOne
    @JoinColumn(name = "debito_id", nullable = false)
    private DebitoEntity debito;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Situacao situacao;

    @Column(name = "data_lancamento", nullable = false)
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "operacao_id", nullable = false)
    private OperacaoEntity operacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_gasto", nullable = false)
    private TipoGasto tipoGasto;

    @ManyToOne
    @JoinColumn(name = "movimentacao_financeira_id") // Pode ser nulo se o orçamento ainda não foi efetivado
    private MovimentacaoFinanceiraEntity movimentacaoFinanceira;

    @ManyToOne
    @JoinColumn(name = "compras_parceladas_id") // Pode ser nulo
    private ComprasParceladasEntity comprasParcelas;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(length = 500)
    private String observacao;

    // Construtor padrão exigido pelo JPA
    public OrcamentoDebitosEntity() {
    }

    public OrcamentoDebitosEntity(Long id, UsuarioEntity usuario, DebitoEntity debito, Situacao situacao, LocalDate dataLancamento, OperacaoEntity operacao, CategoriaEntity categoria, TipoGasto tipoGasto, MovimentacaoFinanceiraEntity movimentacaoFinanceira, ComprasParceladasEntity comprasParcelas, BigDecimal valor, String descricao, String observacao) {
        this.id = id;
        this.usuario = usuario;
        this.debito = debito;
        this.situacao = situacao;
        this.dataLancamento = dataLancamento;
        this.operacao = operacao;
        this.categoria = categoria;
        this.tipoGasto = tipoGasto;
        this.movimentacaoFinanceira = movimentacaoFinanceira;
        this.comprasParcelas = comprasParcelas;
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

    public DebitoEntity getDebito() {
        return debito;
    }

    public void setDebito(DebitoEntity debito) {
        this.debito = debito;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public OperacaoEntity getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoEntity operacao) {
        this.operacao = operacao;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public TipoGasto getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(TipoGasto tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public MovimentacaoFinanceiraEntity getMovimentacaoFinanceira() {
        return movimentacaoFinanceira;
    }

    public void setMovimentacaoFinanceira(MovimentacaoFinanceiraEntity movimentacaoFinanceira) {
        this.movimentacaoFinanceira = movimentacaoFinanceira;
    }

    public ComprasParceladasEntity getComprasParcelas() {
        return comprasParcelas;
    }

    public void setComprasParcelas(ComprasParceladasEntity comprasParcelas) {
        this.comprasParcelas = comprasParcelas;
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
        OrcamentoDebitosEntity that = (OrcamentoDebitosEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrcamentoDebitosEntity{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getId() : "null") +
                ", debito=" + (debito != null ? debito.getId() : "null") +
                ", situacao=" + situacao +
                ", dataLancamento=" + dataLancamento +
                ", operacao=" + (operacao != null ? operacao.getId() : "null") +
                ", categoria=" + (categoria != null ? categoria.getId() : "null") +
                ", tipoGasto=" + tipoGasto +
                ", movimentacaoFinanceira=" + (movimentacaoFinanceira != null ? movimentacaoFinanceira.getId() : "null") +
                ", comprasParcelas=" + (comprasParcelas != null ? comprasParcelas.getId() : "null") +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.entity;

import java.util.Objects;

import com.tsswebapps.financesiapersonal.domain.model.TipoOperacao;

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
@Table(name = "operacao")
public class OperacaoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private UsuarioEntity usuario;

        @Column(nullable = false, length = 255)
        private String descricao;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_operacao", nullable = false)
        private TipoOperacao tipoOperacao;

        public OperacaoEntity() {
        }

        public OperacaoEntity(Long id, UsuarioEntity usuario, String descricao, TipoOperacao tipoOperacao) {
                this.id = id;
                this.usuario = usuario;
                this.descricao = descricao;
                this.tipoOperacao = tipoOperacao;
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

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public TipoOperacao getTipoOperacao() {
                return tipoOperacao;
        }

        public void setTipoOperacao(TipoOperacao tipoOperacao) {
                this.tipoOperacao = tipoOperacao;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                OperacaoEntity that = (OperacaoEntity) o;
                return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }

        @Override
        public String toString() {
                return "OperacaoEntity{" +
                        "id=" + id +
                        ", usuario=" + (usuario != null ? usuario.getId() : "null") + // Evita recursão e mostra ID do usuário
                        ", descricao='" + descricao + '\'' +
                        ", tipoOperacao=" + tipoOperacao +
                        '}';
        }
}

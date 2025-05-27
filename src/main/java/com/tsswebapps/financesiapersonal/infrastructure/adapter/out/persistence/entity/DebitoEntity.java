package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity;

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
@Table(name = "debito")
public class DebitoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private UsuarioEntity usuario;

        @Column(nullable = false, length = 255)
        private String descricao;

        // Construtor padrão exigido pelo JPA
        public DebitoEntity() {
        }

        public DebitoEntity(Long id, UsuarioEntity usuario, String descricao) {
                this.id = id;
                this.usuario = usuario;
                this.descricao = descricao;
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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                DebitoEntity that = (DebitoEntity) o;
                return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }

        @Override
        public String toString() {
                return "DebitoEntity{" +
                        "id=" + id +
                        ", usuario=" + (usuario != null ? usuario.getId() : "null") + // Evita recursão e mostra ID do usuário
                        ", descricao='" + descricao + '\'' +
                        '}';
        }
}

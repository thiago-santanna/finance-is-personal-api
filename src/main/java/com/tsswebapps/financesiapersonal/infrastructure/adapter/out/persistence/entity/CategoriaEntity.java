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
@Table(name = "categoria")
public class CategoriaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private UsuarioEntity usuario;

        @Column(nullable = false, length = 100)
        private String nome;

        @Column(length = 255)
        private String descricao;

        public CategoriaEntity() {
        }

        public CategoriaEntity(Long id, UsuarioEntity usuario, String nome, String descricao) {
                this.id = id;
                this.usuario = usuario;
                this.nome = nome;
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

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
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
                CategoriaEntity that = (CategoriaEntity) o;
                return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }

        @Override
        public String toString() {
                return "CategoriaEntity{" +
                        "id=" + id +
                        ", usuario=" + (usuario != null ? usuario.getId() : "null") + // Evitar recursão infinita e mostrar ID do usuário
                        ", nome='" + nome + '\'' +
                        ", descricao='" + descricao + '\'' +
                        '}';
        }
}

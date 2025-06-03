package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.repository.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}

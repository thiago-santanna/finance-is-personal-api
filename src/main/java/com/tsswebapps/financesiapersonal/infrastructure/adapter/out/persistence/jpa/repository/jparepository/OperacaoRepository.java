package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.repository.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.entity.OperacaoEntity;

@Repository
public interface OperacaoRepository extends JpaRepository<OperacaoEntity, Long> {

}

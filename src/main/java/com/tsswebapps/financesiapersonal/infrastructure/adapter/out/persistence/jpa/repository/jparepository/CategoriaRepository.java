package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.repository.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.entity.CategoriaEntity;


@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}

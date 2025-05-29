package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.repository.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity.DebitoEntity;

@Repository
public interface DebitoRepository extends JpaRepository<DebitoEntity, Long> {

}

package com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.repository.jparepository;

import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity.ComprasParceladasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ComprasParceladasRepository extends JpaRepository<ComprasParceladasEntity, Long> {

}

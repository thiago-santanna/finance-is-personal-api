package com.tsswebapps.financesiapersonal.infrastructure.mapper;

import com.tsswebapps.financesiapersonal.config.CentralMapperConfig;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;
import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface UsuarioEntityMapper {
    UsuarioEntity toEntity(Usuario usuario);
}

package com.tsswebapps.financesiapersonal.infrastructure.mapper;

import com.tsswebapps.financesiapersonal.config.CentralMapperConfig;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;
import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = CentralMapperConfig.class)
public interface UsuarioEntityMapper {
    UsuarioEntity toEntity(Usuario usuario);
}

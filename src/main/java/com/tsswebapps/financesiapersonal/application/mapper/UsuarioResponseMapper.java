package com.tsswebapps.financesiapersonal.application.mapper;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioResponse;
import com.tsswebapps.financesiapersonal.config.CentralMapperConfig;
import com.tsswebapps.financesiapersonal.infrastructure.adapter.out.persistence.jpa.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface UsuarioResponseMapper {
    UsuarioResponse toResponse(UsuarioEntity entity);

}

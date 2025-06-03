package com.tsswebapps.financesiapersonal.application.mapper;

import com.tsswebapps.financesiapersonal.application.dto.UsuarioRequest;
import com.tsswebapps.financesiapersonal.config.CentralMapperConfig;
import com.tsswebapps.financesiapersonal.domain.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface UsuarioRequestMapper {
    Usuario toModel(UsuarioRequest request);
}

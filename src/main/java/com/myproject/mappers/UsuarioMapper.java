package com.myproject.mappers;

import com.myproject.domains.Usuario;
import com.myproject.dtos.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO>{
}

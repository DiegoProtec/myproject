package com.myproject.mappers;

import com.myproject.domains.UsuarioFuncionario;
import com.myproject.dtos.UsuarioFuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioFuncionarioMapper extends BaseMapper<UsuarioFuncionario, UsuarioFuncionarioDTO> {
}

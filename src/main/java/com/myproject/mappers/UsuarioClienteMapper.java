package com.myproject.mappers;

import com.myproject.domains.UsuarioCliente;
import com.myproject.dtos.UsuarioClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioClienteMapper extends BaseMapper<UsuarioCliente, UsuarioClienteDTO>{
}

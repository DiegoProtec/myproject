package com.myproject.mappers;

import com.myproject.domains.Cliente;
import com.myproject.dtos.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDTO>{
}

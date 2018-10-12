package com.myproject.mappers;

import com.myproject.domains.Funcionario;
import com.myproject.dtos.FuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FuncionarioMapper extends BaseMapper<Funcionario, FuncionarioDTO>{
}

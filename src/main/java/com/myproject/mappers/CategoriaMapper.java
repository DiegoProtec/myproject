package com.myproject.mappers;

import com.myproject.domains.Categoria;
import com.myproject.dtos.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaDTO>{
}

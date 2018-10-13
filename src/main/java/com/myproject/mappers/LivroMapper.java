package com.myproject.mappers;

import com.myproject.domains.Livro;
import com.myproject.dtos.LivroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LivroMapper extends BaseMapper<Livro, LivroDTO> {
}

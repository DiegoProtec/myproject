package com.myproject.mappers;

import com.myproject.domains.Autor;
import com.myproject.dtos.AutorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AutorMapper extends BaseMapper<Autor, AutorDTO> {
}

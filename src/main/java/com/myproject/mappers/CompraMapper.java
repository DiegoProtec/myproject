package com.myproject.mappers;

import com.myproject.domains.Compra;
import com.myproject.dtos.CompraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompraMapper extends BaseMapper<Compra, CompraDTO> {
}

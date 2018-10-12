package com.myproject.mappers;

import com.myproject.domains.Boleto;
import com.myproject.dtos.BoletoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoletoMapper extends BaseMapper<Boleto, BoletoDTO>{
}

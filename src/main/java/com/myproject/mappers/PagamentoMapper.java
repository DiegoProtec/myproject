package com.myproject.mappers;

import com.myproject.domains.Pagamento;
import com.myproject.dtos.PagamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PagamentoMapper extends BaseMapper<Pagamento, PagamentoDTO>{
}

package com.myproject.mappers;

import com.myproject.domains.Cartao;
import com.myproject.dtos.CartaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartaoMapper extends BaseMapper<Cartao, CartaoDTO> {
}

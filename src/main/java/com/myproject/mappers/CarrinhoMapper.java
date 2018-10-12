package com.myproject.mappers;

import com.myproject.domains.Carrinho;
import com.myproject.dtos.CarrinhoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarrinhoMapper extends BaseMapper<Carrinho, CarrinhoDTO> {
}

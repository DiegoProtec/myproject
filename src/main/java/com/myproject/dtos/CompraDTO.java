package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class CompraDTO implements Serializable {

    private static final long serialVersionUID = -5738433296374808281L;
    private Long id;

    private LocalDate data;

    private Double valorTotal;

    private PagamentoDTO pagamento;

    private List<CarrinhoDTO> livros;

}

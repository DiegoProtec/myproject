package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class CartaoDTO implements Serializable {

    private static final long serialVersionUID = -8672214713384967882L;

    private Long id;

    private String numero;

    private String titular;

    private LocalDate vencimento;

    private String autenticador;

    private List<ClienteDTO> clientes;

}

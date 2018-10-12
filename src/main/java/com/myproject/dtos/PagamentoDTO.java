package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PagamentoDTO implements Serializable {

    private static final long serialVersionUID = 216587734974844788L;
    private Long id;

    private List<CompraDTO> compras;

}

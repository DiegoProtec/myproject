package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarrinhoDTO implements Serializable {

    private static final long serialVersionUID = -8245350473949359313L;
    private LivroDTO livro;

    private CompraDTO compra;

    private Integer quantidade;

    private Double valorTotalItem;

}

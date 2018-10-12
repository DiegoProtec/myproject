package com.myproject.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = -2632451857421588742L;
    @JsonIgnore
    private Long id;

    private String titulo;

    private String descricao;

    private Double preco;

    private List<AutorDTO> autores;

    private List<CategoriaDTO> categorias;

    private List<CarrinhoDTO> compras;

}

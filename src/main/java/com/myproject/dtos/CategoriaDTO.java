package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = -5181276174943607297L;
    private Long id;

    private String categoria;
}

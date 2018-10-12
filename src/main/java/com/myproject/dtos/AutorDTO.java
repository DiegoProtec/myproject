package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutorDTO implements Serializable {

    private static final long serialVersionUID = -8354187193253293187L;

    private Long id;

    private String nome;

}

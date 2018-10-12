package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioDTO implements Serializable {

    private Long id;

    private String email;

    private String senha;

    private String nome;

}

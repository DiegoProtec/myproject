package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioClienteDTO implements Serializable {

    private static final long serialVersionUID = 3923847538161897589L;
    private UsuarioDTO usuario;

    private ClienteDTO cliente;
}

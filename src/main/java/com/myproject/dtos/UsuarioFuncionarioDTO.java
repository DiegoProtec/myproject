package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioFuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 1400903910066276566L;
    private UsuarioDTO usuario;

    private FuncionarioDTO funcionario;
}

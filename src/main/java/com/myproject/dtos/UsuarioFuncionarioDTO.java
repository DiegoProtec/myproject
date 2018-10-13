package com.myproject.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioFuncionarioDTO implements Serializable {

    private static final long serialVersionUID = -3427475124692498670L;

    @Valid
    private UsuarioDTO usuario;

    @Valid
    private FuncionarioDTO funcionario;
}

package com.myproject.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioFuncionario implements Serializable {

    private static final long serialVersionUID = -111016456339357488L;

    @Valid
    private Usuario usuario;

    @Valid
    private Funcionario funcionario;
}

package com.myproject.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioFuncionario {

    @Valid
    private Usuario usuario;

    @Valid
    private Funcionario funcionario;
}

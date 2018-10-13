package com.myproject.domains;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class UsuarioFuncionario implements Serializable {

    private static final long serialVersionUID = -111016456339357488L;

    private Usuario usuario;

    private Funcionario funcionario;
}

package com.myproject.domains;

import lombok.*;

import javax.validation.Valid;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UsuarioFuncionario implements Serializable {

    private static final long serialVersionUID = -111016456339357488L;

    @Valid
    private Usuario usuario;

    @Valid
    private Funcionario funcionario;
}

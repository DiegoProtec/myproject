package com.myproject.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioClienteDTO implements Serializable {

    private static final long serialVersionUID = -4090951294092040524L;

    @NotNull
    @Valid
    private UsuarioDTO usuario;

    @NotNull
    @Valid
    private ClienteDTO cliente;
}

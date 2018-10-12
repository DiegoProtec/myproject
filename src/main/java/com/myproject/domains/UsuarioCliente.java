package com.myproject.domains;

import lombok.*;

import javax.validation.Valid;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCliente {

    @Valid
    private Usuario usuario;

    @Valid
    private Cliente cliente;

}

package com.myproject.domains;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class UsuarioCliente implements Serializable {

    private static final long serialVersionUID = 1530036924318848854L;

    private Usuario usuario;

    private Cliente cliente;

}

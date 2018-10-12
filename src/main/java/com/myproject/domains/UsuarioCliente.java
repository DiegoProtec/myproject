package com.myproject.domains;

import lombok.*;

import javax.validation.Valid;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UsuarioCliente implements Serializable {

    private static final long serialVersionUID = 1530036924318848854L;

    @Valid
    private Usuario usuario;

    @Valid
    private Cliente cliente;

}

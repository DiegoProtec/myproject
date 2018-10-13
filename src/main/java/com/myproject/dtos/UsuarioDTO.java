package com.myproject.dtos;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -3591916864592418248L;
    private Long id;

    @NotBlank
    @Email
    @Size(min = 8, message = "Mínimo 8 caracteres.")
    @Size(max = 60, message = "Máximo 60 caracteres.")
    private String email;

    @NotBlank
    @Size(min = 6, message = "Mínimo 6 caracteres.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    private String senha;

    @NotBlank
    @Size(min = 5, message = "Mínimo 5 caracteres.")
    @Size(max = 120, message = "Máximo 120 caracteres.")
    private String nome;

}

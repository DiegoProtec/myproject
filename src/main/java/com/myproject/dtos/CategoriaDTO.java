package com.myproject.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = -5181276174943607297L;
    private Long id;

    @NotBlank
    @Size(min = 2, message = "Mínimo 2 caracteres.")
    @Size(max = 150, message = "Máximo 150 caracteres.")
    private String categoria;

}

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
public class AutorDTO implements Serializable {

    private static final long serialVersionUID = -8354187193253293187L;

    private Long id;

    @NotBlank
    @Size(min = 6, message = "Mínimo 6 caracteres.")
    @Size(max = 150, message = "Máximo 150 caracteres.")
    private String nome;

}

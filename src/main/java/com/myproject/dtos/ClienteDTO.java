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
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 6008167171770152525L;

    private Long id;

    @NotBlank
    @Size(min = 11, message = "Mínimo 11 caracteres.")
    @Size(max = 11, message = "Máximo 11 caracteres.")
    private String telefone;

}

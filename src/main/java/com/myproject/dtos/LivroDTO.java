package com.myproject.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class LivroDTO implements Serializable {

    private static final long serialVersionUID = -2632451857421588742L;
    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 2, message = "Mínimo 2 caracteres.")
    @Size(max = 150, message = "Máximo 150 caracteres.")
    private String titulo;


    @Size(max = 150, message = "Máximo 150 caracteres.")
    private String descricao;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double preco;

    private List<AutorDTO> autores;

    private List<CategoriaDTO> categorias;

    private List<CarrinhoDTO> compras;

}

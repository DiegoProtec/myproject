package com.myproject.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class CompraDTO implements Serializable {

    private static final long serialVersionUID = -5738433296374808281L;
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double valorTotal;

    private List<CarrinhoDTO> livros;

}

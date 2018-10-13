package com.myproject.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class CarrinhoDTO implements Serializable {

    private static final long serialVersionUID = -8245350473949359313L;

    @NotNull
    @NumberFormat
    private Integer quantidade;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Double valorTotalItem;

}

package com.myproject.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BoletoDTO implements Serializable {

    private static final long serialVersionUID = -2855449448534016098L;

    private Long id;

    private String codigo;

    private LocalDate vencimento;
}

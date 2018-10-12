package com.myproject.dtos;

import com.myproject.domains.Cartao;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = -9196209249811961204L;

    private Long id;

    private String telefone;

    private Cartao cartao;
}

package com.myproject.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = -7246676034653163571L;
    private Long id;

}

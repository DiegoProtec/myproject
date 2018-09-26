package com.myproject.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public Funcionario() {}
}

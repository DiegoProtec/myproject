package com.myproject.domain;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public Funcionario() {
    }
}

package com.myproject.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "forma_de_pagamento")
public class FormaDePagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

}

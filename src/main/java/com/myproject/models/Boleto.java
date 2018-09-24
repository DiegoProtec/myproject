package com.myproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "boleto")
public class Boleto extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(unique = true)
    private String codigo;

    @NotNull
    @Column(nullable = false)
    private Double valor;

    private LocalDate vencimento;

    public Boleto() {
    }

    public Boleto(String codigo, @NotNull Double valor, LocalDate vencimento) {
        this.codigo = codigo;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }
}

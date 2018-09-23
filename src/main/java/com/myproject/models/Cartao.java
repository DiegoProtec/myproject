package com.myproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cartao")
public class Cartao extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(unique = true, nullable = false)
    private String numero;

    @NotNull
    @Column(nullable = false)
    private String titular;

    @NotNull
    @Column(nullable = false)
    private LocalDate vencimento;

    @NotNull
    @Column(nullable = false)
    private String autenticador;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartao")
    @JoinColumn(name = "cartao_id")
    private List<Cliente> clientes;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public String getAutenticador() {
        return autenticador;
    }

    public void setAutenticador(String autenticador) {
        this.autenticador = autenticador;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}

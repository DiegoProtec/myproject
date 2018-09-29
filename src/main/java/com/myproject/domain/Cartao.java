package com.myproject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

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

    @Column
    @ElementCollection(targetClass=Cliente.class)
    private Set<Cliente> clientes;

    public Cartao() {
    }

    public Cartao(@NotNull String numero, @NotNull String titular, @NotNull LocalDate vencimento, @NotNull String autenticador, Set<Cliente> clientes) {
        this.numero = numero;
        this.titular = titular;
        this.vencimento = vencimento;
        this.autenticador = autenticador;
        this.clientes = clientes;
    }

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

    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}

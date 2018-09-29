package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(nullable = false)
    private String telefone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private Cartao cartao;

    @NotNull
    @Column(nullable = false)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(@NotNull String telefone, Cartao cartao, @NotNull Usuario usuario) {
        this.telefone = telefone;
        this.cartao = cartao;
        this.usuario = usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "usuario_id")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    @Size(min = 11, message = "Mínimo 11 caracteres.")
    @Size(max = 11, message = "Máximo 11 caracteres.")
    @Column(nullable = false)
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private Cartao cartao;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @MapsId
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(
            @NotNull @Size(min = 11, message = "Mínimo 11 caracteres.") @Size(max = 11, message = "Máximo 11 caracteres.") String telefone,
            Usuario usuario) {
        this.telefone = telefone;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

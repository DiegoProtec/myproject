package com.myproject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cartao cartao;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Compra> compras;

    public Cliente() {
    }

    public Cliente(@NotNull String telefone, @NotNull Cartao cartao) {
        this.telefone = telefone;
        this.cartao = cartao;
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

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}

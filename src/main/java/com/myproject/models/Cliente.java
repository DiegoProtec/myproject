package com.myproject.models;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Cartao cartao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JoinColumn(name = "cliente_id")
    private List<Compra> compras;

    public Cliente() {
    }

    public Cliente(@NotNull String telefone, Cartao cartao) {
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
